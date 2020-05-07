package com.federicopintaluba.dreamland.navigation.game

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.federicopintaluba.dreamland.R
import com.federicopintaluba.dreamland.character_classes.CharacterClassName
import com.federicopintaluba.dreamland.common.Constants
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
        setCurrentCharacterValues()
    }

    private fun setCurrentCharacterValues() {
        val preferenceManager = PreferenceManager(requireContext())
        character_name_value.text = preferenceManager.characterName
        character_class_value.text = preferenceManager.characterClass
        character_level_value.text = preferenceManager.characterLevel.toString()
        (character_hp_value_fill.drawable as ClipDrawable).level =
            (preferenceManager.characterCurrentHp / preferenceManager.characterMaxHp) * 10000
        (character_xp_value_fill.drawable as ClipDrawable).level =
            (preferenceManager.characterXp / (Constants.XP_MINIMUM + (preferenceManager.characterLevel * Constants.XP_FACTOR))) * 10000
        character_hp_value.text = String.format(
            getString(R.string.slash_format),
            preferenceManager.characterCurrentHp.toString(),
            preferenceManager.characterMaxHp.toString()
        )
        character_xp_value.text = String.format(
            getString(R.string.slash_format),
            preferenceManager.characterXp.toString(),
            (Constants.XP_MINIMUM + (preferenceManager.characterLevel * Constants.XP_FACTOR)).toString()
        )
        character_atk_value.text =
            Html.fromHtml(String.format(getString(R.string.atk), preferenceManager.characterAtk))
        character_def_value.text =
            Html.fromHtml(String.format(getString(R.string.def), preferenceManager.characterDef))
        character_gold_value.text = preferenceManager.characterGold.toString()

        when (preferenceManager.characterClass) {
            CharacterClassName.BARBARIAN -> character_class_icon.setImageResource(R.drawable.icon_sword_b)
            CharacterClassName.RANGER -> character_class_icon.setImageResource(R.drawable.icon_arrow)
            CharacterClassName.SORCERER -> character_class_icon.setImageResource(R.drawable.icon_purplegem)
        }
    }
}
