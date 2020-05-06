package com.federicopintaluba.dreamland.navigation.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.federicopintaluba.dreamland.R
import com.federicopintaluba.dreamland.preferences.PreferenceManager
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_game, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val preferenceManager = PreferenceManager(requireContext())
        character_name_value.text = preferenceManager.characterName
        character_max_hp_value.text =
            String.format(
                getString(R.string.max_hp_format),
                preferenceManager.characterMaxHp.toString()
            )
        character_hp_value.text = preferenceManager.characterCurrentHp.toString()
        character_atk_value.text = preferenceManager.characterAtk.toString()
        character_def_value.text = preferenceManager.characterDef.toString()
        character_spd_value.text = preferenceManager.characterSpd.toString()
    }
}
