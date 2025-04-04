package com.kanaegel.logos_app2.data // Ensure this package matches your project structure

import com.google.gson.annotations.SerializedName // Import Gson annotation

/**
 * Kotlin data class representing a lexical entry, designed for use with Gson.
 * Based on the original Java class using Jackson.
 * Note: Gson ignores unknown JSON properties by default, similar to
 * Jackson's @JsonIgnoreProperties(ignoreUnknown = true).
 * All fields are declared as nullable Strings (String?) assuming they might be absent or null in the JSON.
 */
data class StrongsApiResponseData(

    // Maps JSON key "StrNo" to Kotlin property strNo
    @SerializedName("StrNo")
    val strNo: String?,

    @SerializedName("StepGloss")
    val stepGloss: String?,

    @SerializedName("STEPUnicodeAccented")
    val stepUnicodeAccented: String?,

    @SerializedName("STEPTranslit")
    val stepTranslit: String?,

    @SerializedName("ShortDef")
    val shortDef: String?,

    @SerializedName("BdbMedDef")
    val bdbMedDef: String?,

    @SerializedName("Translations")
    val translations: String?,

    @SerializedName("StrTranslit")
    val strTranslit: String?,

    @SerializedName("StepEtym")
    val stepEtym: String?,

    @SerializedName("StrFreq")
    val strFreq: String?,

    @SerializedName("STEP_UnitedReason")
    val stepUnitedReason: String?,

    @SerializedName("STEP_LexicalGroup")
    val stepLexicalGroup: String?,

    @SerializedName("STEP_Type")
    val stepType: String?,

    @SerializedName("STEP_Link")
    val stepLink: String?,

    @SerializedName("AltStrongTags")
    val altStrongTags: String?,

    @SerializedName("StepRelatedNos2")
    val stepRelatedNos2: String?,

    // Assuming "LXX" was the intended JSON key for the 'lxx' field
    @SerializedName("LXX")
    val lxx: String?,

    @SerializedName("STEP_DetailLexicalTag")
    val stepDetailLexicalTag: String?,

    @SerializedName("AcadTransAccented")
    val acadTransAccented: String?,

    @SerializedName("AcadTransUnaccented")
    val acadTransUnaccented: String?,

    // Assuming "2llUnaccented" was the intended JSON key for the 'llUnaccented' field
    @SerializedName("2llUnaccented")
    val llUnaccented: String?,

    @SerializedName("SearchResultRange")
    val searchResultRange: String?,

    @SerializedName("StopWord")
    val stopWord: String?

    // No explicit constructor, getters, setters, equals, hashCode, or toString needed.
    // Kotlin data class provides them automatically.
)
