package com.kanaegel.logos_app2.ui.home

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.kanaegel.logos_app2.LoginActivity
import com.kanaegel.logos_app2.MainActivity
import com.kanaegel.logos_app2.StrongsEntry
import com.kanaegel.logos_app2.databinding.FragmentHomeBinding
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val LOG_TAG = "HomeFragment"

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        updateUI(homeViewModel.json.value)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding?.swipeRefreshLayout?.setOnRefreshListener {
            Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout")
            myUpdateOperation(homeViewModel)
        }

        return root
    }

    fun myUpdateOperation( viewModel : HomeViewModel ){
        val homeViewModel = viewModel
        homeViewModel.fetchApiData()
        updateUI(homeViewModel.json.value)
        _binding?.swipeRefreshLayout?.isRefreshing = false

    }

    private fun updateUI(entry: StrongsEntry?) {
        binding.strongsNumber.text = entry?.strongsNumber
        binding.wordHebrew.text = entry?.word
        binding.word.text = entry?.englishWord?.capitalize(Locale.ROOT)
        binding.phoenticSpelling.text = entry?.transliteration.toString()
        binding.descriptionBody.text = Html.fromHtml(entry?.definition.toString(), Html.FROM_HTML_MODE_LEGACY)
        binding.descriptionBody2.text = Html.fromHtml(entry?.entymology.toString(), Html.FROM_HTML_MODE_LEGACY)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}