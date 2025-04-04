package com.kanaegel.logos_app2.ui.home

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
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

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val LOG_TAG = "HomeFragment"
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var logoutButton : android.widget.Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        logoutButton.setOnClickListener {
//            logout()
//        }

        _binding?.swipeRefreshLayout?.setOnRefreshListener {
            Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout")
            myUpdateOperation()
        }

        return root
    }

    fun myUpdateOperation(){
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.fetchApiData()
        updateUI(homeViewModel.json.value)
        _binding?.swipeRefreshLayout?.isRefreshing = false

    }

    private fun updateUI(entry: StrongsEntry?) {
        binding.strongsNumber.text = entry?.strongsNumber
        binding.wordHebrew.text = entry?.word
        binding.word.text = entry?.englishWord // Or a different field if needed
        binding.phoenticSpelling.text = entry?.transliteration
        binding.descriptionBody.text = bulletedList(entry?.definition.toString())

    }

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

//
//    private fun logout() {
//        auth.signOut()
//        if (auth.currentUser == null) {
//            Toast.makeText(requireContext(), "Logout successful.", Toast.LENGTH_SHORT)
//            navigateToLogin(auth.currentUser)
//        }
//    }
//
//    private fun navigateToLogin(currentUser: FirebaseUser?) {
//        if (currentUser == null) {
//            val intent = Intent(this.context, LoginActivity::class.java)
//            startActivity(intent)
//            onDestroyView()
//        }
//    }
}