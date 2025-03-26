package com.kanaegel.logos_app2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kanaegel.logos_app2.data.LexicalEntry;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractLexicalEntry implements LexicalEntry {
    private String strongNumber;
    private String stepGloss;
    private String stepTransliteration;
    private String accentedUnicode;
    private String shortDefinition;
    private String kjs;
    private String stepInflection;
    private String stepUnited;
    private String stepLexicalGroup;
    private String stepType;
    private String stepLink;
    private int count;


    @Override
    public String getStrongNumber() {
        return strongNumber;
    }

    @Override
    public void setStrongNumber(String strongNumber) {
        this.strongNumber = strongNumber;
    }

    @Override
    public String getStepGloss() {
        return stepGloss;
    }

    @Override
    public void setStepGloss(String stepGloss) {
        this.stepGloss = stepGloss;
    }

    @Override
    public String getStepTransliteration() {
        return stepTransliteration;
    }

    @Override
    public void setStepTransliteration(String stepTransliteration) {
        this.stepTransliteration = stepTransliteration;
    }

    @Override
    public String getAccentedUnicode() {
        return accentedUnicode;
    }

    @Override
    public void setAccentedUnicode(String accentedUnicode) {
        this.accentedUnicode = accentedUnicode;
    }

    @Override
    public String getShortDefinition() {
        return shortDefinition;
    }

    @Override
    public void setShortDefinition(String shortDefinition) {
        this.shortDefinition = shortDefinition;
    }

    @Override
    public String getKjs() {
        return kjs;
    }

    @Override
    public void setKjs(String kjs) {
        this.kjs = kjs;
    }

    @Override
    public String getStepInflection() {
        return stepInflection;
    }
    @Override
    public void setStepInflection(String stepInflection){
        this.stepInflection = stepInflection;
    }
    @Override
    public String getStepUnited() {
        return stepUnited;
    }
    @Override
    public void setStepUnited(String stepUnited) {
        this.stepUnited = stepUnited;
    }
    @Override
    public String getStepLexicalGroup() {
        return stepLexicalGroup;
    }
    @Override
    public void setStepLexicalGroup(String stepLexicalGroup) {
        this.stepLexicalGroup = stepLexicalGroup;
    }

    @Override
    public String getStepType() {
        return stepType;
    }
    @Override
    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    @Override
    public String getStepLink() {
        return stepLink;
    }
    @Override
    public void setStepLink(String stepLink) {
        this.stepLink = stepLink;
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