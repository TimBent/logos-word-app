package com.kanaegel.logos_app2.model; // Corrected package

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GreekLexicalEntry extends AbstractLexicalEntry {
    // Greek-specific fields
    private String simplifiedStepTransliteration; // Field present in GreekWord.java
    private List<AlternativeType> altStrongs;
    private String relatedNos;
    private int count;


    // Getters and setters for Greek-specific fields
    public String getSimplifiedStepTransliteration() {
        return simplifiedStepTransliteration;
    }

    public void setSimplifiedStepTransliteration(String simplifiedStepTransliteration) {
        this.simplifiedStepTransliteration = simplifiedStepTransliteration;
    }

    public List<AlternativeType> getAltStrongs() {
        return altStrongs;
    }
    public void setAltStrongs(List<AlternativeType> altStrongs) {
        this.altStrongs = altStrongs;
    }
    public String getRelatedNos() {
        return relatedNos;
    }
    public void setRelatedNos(String relatedNos) {
        this.relatedNos = relatedNos;
    }
    @Override
    public int getCount(){
        return count;
    }
    @Override
    public void setCount(int count){
        this.count = count;
    }

}