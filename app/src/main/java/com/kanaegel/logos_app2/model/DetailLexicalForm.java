package com.kanaegel.logos_app2.model; // Corrected package

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailLexicalForm {

    private String detailLexicalTag;

    public String getDetailLexicalTag() {
        return detailLexicalTag;
    }

    public void setDetailLexicalTag(String detailLexicalTag) {
        this.detailLexicalTag = detailLexicalTag;
    }
    public DetailLexicalForm() {}
}