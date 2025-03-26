package com.kanaegel.logos_app2.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleLexicalEntry {

    @JsonProperty("StrNo") // Maps JSON key "StrNo" to Java field strNo
    private String strNo;

    @JsonProperty("StepGloss")
    private String stepGloss;

    @JsonProperty("STEPUnicodeAccented")
    private String stepUnicodeAccented;

    @JsonProperty("STEPTranslit")
    private String stepTranslit;

    @JsonProperty("BdbMedDef")
    private String bdbMedDef;

    @JsonProperty("Translations")
    private String translations;

    @JsonProperty("StrTranslit")
    private String strTranslit;

    @JsonProperty("StepEtym")
    private String stepEtym;

    @JsonProperty("StrFreq")
    private String strFreq;

    @JsonProperty("STEP_UnitedReason")
    private String stepUnitedReason;

    @JsonProperty("STEP_LexicalGroup")
    private String stepLexicalGroup;

    @JsonProperty("STEP_Type")
    private String stepType;

    @JsonProperty("STEP_Link")
    private String stepLink;

    @JsonProperty("AltStrongTags")
    private String altStrongTags;

    @JsonProperty("StepRelatedNos2")
    private String stepRelatedNos2;

    @JsonProperty("LXX")
    private String lxx;

    @JsonProperty("STEP_DetailLexicalTag")
    private String stepDetailLexicalTag;

    @JsonProperty("AcadTransAccented")
    private String acadTransAccented;

    @JsonProperty("AcadTransUnaccented")
    private String acadTransUnaccented;

    @JsonProperty("2llUnaccented")
    private String llUnaccented;

    @JsonProperty("SearchResultRange")
    private String searchResultRange;

    @JsonProperty("StopWord")
    private String stopWord;


    // Getters and setters (still needed, even with annotations!)
    public String getStrNo() { return strNo; }
    public void setStrNo(String strNo) { this.strNo = strNo; }

    public String getStepGloss() { return stepGloss; }
    public void setStepGloss(String stepGloss) { this.stepGloss = stepGloss; }

    public String getSTEPUnicodeAccented() { return stepUnicodeAccented; }
    public void setSTEPUnicodeAccented(String stepUnicodeAccented) { this.stepUnicodeAccented = stepUnicodeAccented; }

    public String getSTEPTranslit() { return stepTranslit; }
    public void setSTEPTranslit(String stepTranslit) { this.stepTranslit = stepTranslit; }

    public String getBdbMedDef() { return bdbMedDef; }
    public void setBdbMedDef(String bdbMedDef) { this.bdbMedDef = bdbMedDef; }

    public String getTranslations() { return translations; }
    public void setTranslations(String translations) { this.translations = translations; }

    public String getStrTranslit() { return strTranslit; }
    public void setStrTranslit(String strTranslit) { this.strTranslit = strTranslit; }

    public String getStepEtym() { return stepEtym; }
    public void setStepEtym(String stepEtym) { this.stepEtym = stepEtym; }

    public String getStrFreq() { return strFreq; }
    public void setStrFreq(String strFreq) { this.strFreq = strFreq; }

    public String getSTEP_UnitedReason() { return stepUnitedReason; }
    public void setSTEP_UnitedReason(String stepUnitedReason) { this.stepUnitedReason = stepUnitedReason; }

    public String getSTEP_LexicalGroup() { return stepLexicalGroup; }
    public void setSTEP_LexicalGroup(String stepLexicalGroup) { this.stepLexicalGroup = stepLexicalGroup; }

    public String getSTEP_Type() { return stepType; }
    public void setSTEP_Type(String stepType) { this.stepType = stepType; }

    public String getSTEP_Link() { return stepLink; }
    public void setSTEP_Link(String stepLink) { this.stepLink = stepLink; }

    public String getAltStrongTags() { return altStrongTags; }
    public void setAltStrongTags(String altStrongTags) { this.altStrongTags = altStrongTags; }

    public String getStepRelatedNos2() { return stepRelatedNos2; }
    public void setStepRelatedNos2(String stepRelatedNos2) { this.stepRelatedNos2 = stepRelatedNos2; }

    public String getLXX() { return lxx; }
    public void setLXX(String lxx) { this.lxx = lxx; }

    public String getSTEP_DetailLexicalTag() { return stepDetailLexicalTag; }
    public void setSTEP_DetailLexicalTag(String stepDetailLexicalTag) { this.stepDetailLexicalTag = stepDetailLexicalTag; }

    public String getAcadTransAccented() { return acadTransAccented; }
    public void setAcadTransAccented(String acadTransAccented) { this.acadTransAccented = acadTransAccented; }

    public String getAcadTransUnaccented() { return acadTransUnaccented; }
    public void setAcadTransUnaccented(String acadTransUnaccented) { this.acadTransUnaccented = acadTransUnaccented; }

    public String get2llUnaccented() { return llUnaccented; }
    public void set2llUnaccented(String llUnaccented) { this.llUnaccented = llUnaccented; }

    public String getSearchResultRange() { return searchResultRange; }
    public void setSearchResultRange(String searchResultRange) { this.searchResultRange = searchResultRange; }

    public String getStopWord() { return stopWord; }
    public void setStopWord(String stopWord) { this.stopWord = stopWord; }
    // No-argument constructor (required by Jackson)
    public SimpleLexicalEntry() {}

    @Override
    public String toString() {
        return "SimpleLexicalEntry{" +
                "StrNo='" + strNo + '\'' +
                ", StepGloss='" + stepGloss + '\'' +
                ", STEPUnicodeAccented='" + stepUnicodeAccented + '\'' +
                ", STEPTranslit='" + stepTranslit + '\'' +
                ", BdbMedDef='" + bdbMedDef + '\'' +
                ", Translations='" + translations + '\'' +
                ", StrTranslit='" + strTranslit + '\'' +
                ", StepEtym='" + stepEtym + '\'' +
                ", StrFreq='" + strFreq + '\'' +
                ", STEP_UnitedReason='" + stepUnitedReason + '\'' +
                ", STEP_LexicalGroup='" + stepLexicalGroup + '\'' +
                ", STEP_Type='" + stepType + '\'' +
                ", STEP_Link='" + stepLink + '\'' +
                ", AltStrongTags='" + altStrongTags + '\'' +
                ", StepRelatedNos2='" + stepRelatedNos2 + '\'' +
                ", LXX='" + lxx + '\'' +
                ", STEP_DetailLexicalTag='" + stepDetailLexicalTag + '\'' +
                ", AcadTransAccented='" + acadTransAccented + '\'' +
                ", AcadTransUnaccented='" + acadTransUnaccented + '\'' +
                ", llUnaccented='" + llUnaccented + '\'' +
                ", SearchResultRange='" + searchResultRange + '\'' +
                ", StopWord='" + stopWord + '\'' +
                '}';
    }
}