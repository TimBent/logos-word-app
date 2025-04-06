package com.kanaegel.logos_app2.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.kanaegel.logos_app2.LoginActivity
import com.kanaegel.logos_app2.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        auth = FirebaseAuth.getInstance()

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding?.logoutButton?.setOnClickListener {
            logout()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun logout() {
        auth.signOut()
        if (auth.currentUser == null) {
            Toast.makeText(requireContext(), "Logout successful.", Toast.LENGTH_SHORT)
            navigateToLogin(auth.currentUser)
        }
    }

    private fun navigateToLogin(currentUser: FirebaseUser?) {
        if (currentUser == null) {
            val intent = Intent(this.context, LoginActivity::class.java)
            startActivity(intent)
            onDestroyView()
        }
    }
}