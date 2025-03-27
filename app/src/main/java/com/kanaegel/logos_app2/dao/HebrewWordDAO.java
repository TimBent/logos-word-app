package com.kanaegel.logos_app2.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kanaegel.logos_app2.data.SimpleLexicalEntry;
import com.kanaegel.logos_app2.model.AlternativeType;
import com.kanaegel.logos_app2.model.DetailLexicalForm;
import com.kanaegel.logos_app2.model.HebrewLexicalEntry;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class HebrewWordDAO {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private final ObjectMapper objectMapper;

    public HebrewWordDAO(String url, String user, String password) {
        this.dbUrl = url;
        this.dbUser = user;
        this.dbPassword = password;
        this.objectMapper = new ObjectMapper(); // Initialize Jackson ObjectMapper
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL driver not found", e);
        }
    }

    public List<HebrewLexicalEntry> getAllHebrewWords() throws SQLException {
        List<HebrewLexicalEntry> words = new ArrayList<>();
        String sql = "SELECT data FROM hebrew_lexicon";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String jsonData = rs.getString("data");
                System.out.println("JSON Data: " + jsonData); // Keep this print statement
                try {
                    SimpleLexicalEntry simpleEntry = objectMapper.readValue(jsonData, SimpleLexicalEntry.class);
                    System.out.println("SimpleLexicalEntry: " + simpleEntry); // Keep this!
                    HebrewLexicalEntry hebrewWord = convertToHebrewLexicalEntry(simpleEntry);
                    words.add(hebrewWord);
                } catch (Exception e) {
                    System.err.println("Error parsing JSON data: " + e.getMessage());
                }
            }
        }
        return words;
    }

    public HebrewLexicalEntry getHebrewWordByStrongNumber(String strongNumber) throws SQLException {
        HebrewLexicalEntry hebrewWord = null;
        String sql = "SELECT data FROM hebrew_lexicon WHERE data->>'StrNo' = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, strongNumber);
            System.out.println("Executing SQL: " + pstmt); // Keep this print statement
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String jsonData = rs.getString("data");
                    System.out.println("JSON Data for " + strongNumber + ": " + jsonData); // Keep this!
                    try {
                        SimpleLexicalEntry simpleEntry = objectMapper.readValue(jsonData, SimpleLexicalEntry.class);
                        System.out.println("SimpleLexicalEntry: " + simpleEntry);
                        hebrewWord = convertToHebrewLexicalEntry(simpleEntry);
                    } catch (Exception e) {
                        System.err.println("Error parsing JSON data: " + e.getMessage());
                        throw new SQLException("Error parsing JSON for Strong number: " + strongNumber, e);
                    }
                } else {
                    System.out.println("No entry found for Strong number: " + strongNumber); // Keep
                }
            }
        }
        return hebrewWord;
    }
    //Could create a Greek DAO if required.
    private HebrewLexicalEntry convertToHebrewLexicalEntry(SimpleLexicalEntry simpleEntry) {
        HebrewLexicalEntry hebrewWord = new HebrewLexicalEntry();
        hebrewWord.setStrongNumber(simpleEntry.getStrNo());
        hebrewWord.setStepGloss(simpleEntry.getStepGloss());
        hebrewWord.setStepTransliteration(simpleEntry.getSTEPTranslit() != null ? simpleEntry.getSTEPTranslit() : simpleEntry.getSTEPUnicodeAccented());
        hebrewWord.setAccentedUnicode(simpleEntry.getStrTranslit());
        hebrewWord.setShortDefinition(simpleEntry.getBdbMedDef());
        hebrewWord.setKjs(simpleEntry.getTranslations());
        hebrewWord.setStepInflection(simpleEntry.getStepEtym());
        hebrewWord.setStepUnited(simpleEntry.getSTEP_UnitedReason());
        hebrewWord.setStepLexicalGroup(simpleEntry.getSTEP_LexicalGroup());
        hebrewWord.setStepType(simpleEntry.getSTEP_Type());
        hebrewWord.setStepLink(simpleEntry.getSTEP_Link());
        hebrewWord.setRelatedNos(simpleEntry.getStepRelatedNos2());
        hebrewWord.setLxxOccurrences(simpleEntry.getLXX()); // Corrected method name
        if (simpleEntry.getStrFreq() != null && !simpleEntry.getStrFreq().isEmpty()){
            try {
                hebrewWord.setCount(Integer.parseInt(simpleEntry.getStrFreq()));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing frequency: " + simpleEntry.getStrFreq() + " for Strong number: " + simpleEntry.getStrNo());
                hebrewWord.setCount(0);
            }
        }

        hebrewWord.setSimplifiedStepTransliteration(simpleEntry.get2llUnaccented());
        hebrewWord.setAlternativeTranslit1(simpleEntry.getAcadTransAccented());
        hebrewWord.setAlternativeTranslit2(simpleEntry.getAcadTransUnaccented());

        if (simpleEntry.getAltStrongTags() != null) {
            String[] altTags = simpleEntry.getAltStrongTags().split(",\\s*");
            List<AlternativeType> altStrongList = new ArrayList<>();
            for (String tag : altTags) {
                try{
                    AlternativeType altType = AlternativeType.valueOf("MISC"); //Default to a value
                    altStrongList.add(altType);

                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid AlternativeType value: " + tag + "This has been set to MISC");
                }
            }
            hebrewWord.setAltStrongs(altStrongList);
        }
        if (simpleEntry.getSTEP_DetailLexicalTag() != null) {
            try {
                JsonNode detailLexicalTagNode = objectMapper.readTree(simpleEntry.getSTEP_DetailLexicalTag());
                List<DetailLexicalForm> detailForms = new ArrayList<>();
                flattenDetailLexicalForms(detailLexicalTagNode, detailForms); // Use helper function
                hebrewWord.setDetailLexicalForms(detailForms);
            } catch (Exception e) {
                System.err.println("Error parsing STEP_DetailLexicalTag: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return hebrewWord;
    }

    private void flattenDetailLexicalForms(JsonNode node, List<DetailLexicalForm> result) throws JsonProcessingException {
        if (node.isArray()) {
            for (JsonNode element : node) {
                flattenDetailLexicalForms(element, result); // Recursive call
            }
        } else if (node.isObject()) {
            // Attempt to deserialize as DetailLexicalForm
            try {
                DetailLexicalForm form = objectMapper.treeToValue(node, DetailLexicalForm.class);
                result.add(form);
            } catch (JsonProcessingException e) {
                // Could not convert to DetailLexicalForm, potentially a problem.
                System.err.println("Could not convert to DetailLexicalForm: " + node.toString());
            }
        }
    }

}