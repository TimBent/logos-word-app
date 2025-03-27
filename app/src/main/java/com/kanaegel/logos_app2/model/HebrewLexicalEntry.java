package com.kanaegel.logos_app2.model;

import java.util.List;
public class HebrewLexicalEntry extends AbstractLexicalEntry {
    // Hebrew-specific fields
    private String simplifiedStepTransliteration;
    private String alternativeTranslit1; //Was present in your original HebrewWord class.
    private String alternativeTranslit2;
    private List<AlternativeType> altStrongs;
    private String lxxOccurrences;
    private String relatedNos;
    private List<DetailLexicalForm> detailLexicalForms;


    public String getSimplifiedStepTransliteration() {
        return simplifiedStepTransliteration;
    }
    public void setSimplifiedStepTransliteration(String simplifiedStepTransliteration) {
        this.simplifiedStepTransliteration = simplifiedStepTransliteration;
    }
    public String getAlternativeTranslit1() {
        return alternativeTranslit1;
    }
    public void setAlternativeTranslit1(String alternativeTranslit1) {
        this.alternativeTranslit1 = alternativeTranslit1;
    }
    public String getAlternativeTranslit2() {
        return alternativeTranslit2;
    }
    public void setAlternativeTranslit2(String alternativeTranslit2) {
        this.alternativeTranslit2 = alternativeTranslit2;
    }

    public List<AlternativeType> getAltStrongs() {
        return altStrongs;
    }
    public void setAltStrongs(List<AlternativeType> altStrongs) {
        this.altStrongs = altStrongs;
    }

    public String getLxxOccurrences() {
        return lxxOccurrences;
    }

    public void setLxxOccurrences(String lxxOccurrences) {
        this.lxxOccurrences = lxxOccurrences;
    }
    public String getRelatedNos() {
        return relatedNos;
    }
    public void setRelatedNos(String relatedNos) {
        this.relatedNos = relatedNos;
    }

    public List<DetailLexicalForm> getDetailLexicalForms() {
        return detailLexicalForms;
    }

    public void setDetailLexicalForms(List<DetailLexicalForm> detailLexicalForms) {
        this.detailLexicalForms = detailLexicalForms;
    }
}