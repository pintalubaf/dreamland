package com.federicopintaluba.dreamland.navigation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.federicopintaluba.dreamland.R
import com.federicopintaluba.dreamland.preferences.PreferenceManager
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_welcome, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val preferences = PreferenceManager(requireContext())
        if (preferences.characterCreated) {
            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToGameFragment()

            findNavController().navigate(action)
        } else {
            setCreateCharacterButtonListener()
        }
    }

    private fun setCreateCharacterButtonListener() {
        create_character_button.setOnClickListener {
            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToCharacterCreationFragment()

            it.findNavController().navigate(action)
        }
    }
}
