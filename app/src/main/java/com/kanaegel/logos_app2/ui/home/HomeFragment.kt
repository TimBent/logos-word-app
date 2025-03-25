package com.kanaegel.logos_app2.ui.home

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kanaegel.logos_app2.StrongsEntry
import com.kanaegel.logos_app2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        updateUI( strongsEntry)

        return root
    }

    private fun updateUI(entry: StrongsEntry) {
        binding.strongsNumber.text = entry.strongsNumber
        binding.wordHebrew.text = entry.word
        binding.word.text = entry.englishWord // Or a different field if needed
        binding.phoenticSpelling.text = entry.transliteration
        binding.descriptionBody.text = bulletedList(entry.definition)

    }

    val strongsEntry = StrongsEntry(
    0, "H0430G","אֱלֹהִים","God","(e-lo-him)","God, usually refers to the one true God; " +
    "\n in a very few contexts it refers to a (pagan) god or goddess. The \"Son of God\" as a title of Jesus emphasizes his unique relationship to the Father. \"The god of this age\" refers to the devil\n" +
    "a deity, Acts 7:43; 1Cor. 8:5; an idol, Acts 7:40; God, the true God, Mt. 3:9, and frequently ;\n" +
    "God, possessed of true godhead, Jn. 1:1; Rom. 9:5; from the Hebrew, applied to potentates, Jn. 10:34, 35;\n" +
    "τῶ θεῶ, an intensive term, from the Hebrew, exceedingly, Acts 7:20, and, perhaps, 2Cor. 10:4\n",
    listOf("without God (atheos - ἄθεος)",
    "goddess (thea - θεά)",
    "divine (theios - θεῖος)",
    "to fight God (theomacheō - θεομαχέω)",
    "opposing God (theomachos - θεομάχος)",
    "God-breathed (theopneustos - θεόπνευστος)",
    "God-hating (theostugēs - θεοστυγής)",
    "deity"),
    listOf("חֲשׁוֹךְ", "חָשַׁךְ", "חָשֹׁךְ"),
    listOf("cha.shokh", "cha.shakh", "cha.shokh")
    )

    fun bulletedList( originalText : String ) : String {
        val bulletedText = StringBuilder()
        val lines = originalText.lines() // Split into lines

        for (line in lines) {
            val trimmedLine = line.trim() // Remove leading/trailing whitespace
            if (trimmedLine.isNotEmpty()) { // Skip empty lines
                bulletedText.append("• ").append(trimmedLine).append("\n")
            }
        }

        return bulletedText.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}