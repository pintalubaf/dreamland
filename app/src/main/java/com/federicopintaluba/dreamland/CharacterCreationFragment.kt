package com.federicopintaluba.dreamland

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CharacterCreationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_character_creation, container, false)


    companion object {

        @JvmStatic
        fun newInstance() =
            CharacterCreationFragment()
    }
}
