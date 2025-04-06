package com.kanaegel.logos_app2.core

import android.text.SpannableString
import android.text.style.StyleSpan
import com.fasterxml.jackson.databind.ObjectMapper
import com.kanaegel.logos_app2.StrongsEntry
import com.kanaegel.logos_app2.data.SimpleLexicalEntry
import com.kanaegel.logos_app2.data.StrongsApiResponseData

class StrongsEntryService {

    private val objectMapper : ObjectMapper = ObjectMapper()

    fun toStrongsEntry(json: String): StrongsEntry {
        val simpleEntry: SimpleLexicalEntry? =
            objectMapper.readValue(json, SimpleLexicalEntry::class.java)

    return if (simpleEntry != null) {
           StrongsEntry(
               1,
               simpleEntry.getStrNo(),
               simpleEntry.getStepGloss(),
               simpleEntry.getSTEPUnicodeAccented(),
               simpleEntry.getSTEPTranslit(),
               "",
               "",
               listOf(),
               listOf(),
               listOf()
           )
       } else {
           StrongsEntry(
               1,
               "",
               "",
               "",
               "",
               "",
               "",
               listOf(),
               listOf(),
               listOf()
           )
       }
    }

    fun toStrongsEntryFromSimpleEntry(simpleEntry: StrongsApiResponseData): StrongsEntry {

        return if (simpleEntry != null) {
            StrongsEntry(
                1,
                simpleEntry.strNo,
                simpleEntry.stepUnicodeAccented,
                simpleEntry.stepGloss,
                simpleEntry.stepTranslit,
                simpleEntry.bdbMedDef,
                simpleEntry.stepEtym,
                listOf(),
                listOf(),
                listOf()
            )
        } else {
            StrongsEntry(
                1,
                "",
                "",
                "",
                "",
                "",
                "",
                listOf(),
                listOf(),
                listOf()
            )
        }
    }

    fun removeHtmlTags(input: String?): SpannableString {
        val spannableString = SpannableString(input)
        val boldTagRegex = Regex("<b>(.*?)</b>") // Regex to find bold tags and content
        val newlineTagRegex = Regex("<br>")

        boldTagRegex.findAll(input.toString()).forEach { matchResult ->
            val start = matchResult.range.first
            val end = matchResult.range.last
            spannableString.setSpan(
                StyleSpan(android.graphics.Typeface.BOLD),
                start,
                end,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        newlineTagRegex.findAll(spannableString.toString()).forEach { matchResult ->
            val start = matchResult.range.first
            val end = matchResult.range.last
            spannableString.setSpan(
                "\n",
                start,
                end,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )

        }
        return spannableString
    }
}