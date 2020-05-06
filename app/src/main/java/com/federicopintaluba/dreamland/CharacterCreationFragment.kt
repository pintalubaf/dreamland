package com.federicopintaluba.dreamland

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_character_creation.*

class CharacterCreationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_character_creation, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setCharacterClassSelectorListeners()
    }

    private fun setCharacterClassSelectorListeners() {
        class_barbarian_radio.setOnClickListener {
            character_class_description.text = getString(R.string.barbarian_description)
        }

        class_ranger_radio.setOnClickListener {
            character_class_description.text = getString(R.string.ranger_description)
        }

        class_sorcerer_radio.setOnClickListener {
            character_class_description.text = getString(R.string.sorcerer_description)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CharacterCreationFragment()
    }
}
