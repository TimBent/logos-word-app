package com.kanaegel.logos_app2.data;

public interface LexicalEntry {
    String getStrongNumber();
    void setStrongNumber(String strongNumber);

    String getStepGloss();
    void setStepGloss(String stepGloss);

    String getStepTransliteration();
    void setStepTransliteration(String stepTransliteration);

    String getAccentedUnicode();
    void setAccentedUnicode(String accentedUnicode);

    String getShortDefinition();
    void setShortDefinition(String shortDefinition);

    String getKjs();
    void setKjs(String kjs);

    String getStepInflection();
    void setStepInflection(String stepInflection);

    // Add other common methods as needed (e.g., get/set for other fields)
    void setStepUnited(String stepUnited);
    String getStepUnited();

    void setStepLexicalGroup(String stepLexicalGroup);
    String getStepLexicalGroup();

    void setStepType(String stepType);
    String getStepType();

    void setStepLink(String stepLink);
    String getStepLink();

    void setCount(int count);
    int getCount();
}