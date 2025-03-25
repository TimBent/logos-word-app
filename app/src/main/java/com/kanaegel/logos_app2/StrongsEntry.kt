package com.kanaegel.logos_app2

class StrongsEntry(
    var id: Int,
    var strongsNumber: String,
    var word: String,
    var englishWord: String,
    var transliteration: String,
    var definition: String,
    var relatedWords: List<String>,
    var relatedWordsHebrew: List<String>,
    var relatedWordsTransliteration: List<String>
)