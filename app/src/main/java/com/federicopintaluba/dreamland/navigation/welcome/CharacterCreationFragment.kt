package com.federicopintaluba.dreamland.navigation.welcome

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.federicopintaluba.dreamland.R
import com.federicopintaluba.dreamland.character_classes.BarbarianClass
import com.federicopintaluba.dreamland.character_classes.CharacterClass
import com.federicopintaluba.dreamland.character_classes.RangerClass
import com.federicopintaluba.dreamland.character_classes.SorcererClass
import com.federicopintaluba.dreamland.preferences.PreferenceManager
import kotlinx.android.synthetic.main.fragment_character_creation.*

class CharacterCreationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_character_creation, container, false)

    private var selectedName = ""
    private var selectedClass: CharacterClass = BarbarianClass()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setCharacterClassSelectorListeners()
        setCreateCharacterButtonListener()
        updateCharacterClassAttributesDescription()
    }

    private fun setCharacterClassSelectorListeners() {
        class_barbarian_radio.setOnClickListener {
            selectedClass = BarbarianClass()
            character_class_description.text = getString(R.string.barbarian_description)
            updateCharacterClassAttributesDescription()
        }

        class_ranger_radio.setOnClickListener {
            selectedClass = RangerClass()
            character_class_description.text = getString(R.string.ranger_description)
            updateCharacterClassAttributesDescription()
        }

        class_sorcerer_radio.setOnClickListener {
            selectedClass = SorcererClass()
            character_class_description.text = getString(R.string.sorcerer_description)
            updateCharacterClassAttributesDescription()
        }
    }

    private fun updateCharacterClassAttributesDescription() {
        character_class_attributes.text =
            Html.fromHtml(
                String.format(
                    getString(R.string.character_class_attributes),
                    selectedClass.startingHp,
                    selectedClass.startingAtk,
                    selectedClass.startingDef,
                    selectedClass.startingSpeed
                )
            )
    }

    private fun setCreateCharacterButtonListener() {
        create_character_button.setOnClickListener {
            if (checkIfCharacterNameIsValid()) {
                showConfirmationDialog()
            }
        }
    }

    private fun checkIfCharacterNameIsValid(): Boolean {
        if (character_name_edit_text.text.isEmpty()) {
            showErrorDialog("You must select a name for the character!")
            return false
        }

        selectedName = character_name_edit_text.text.toString()
        return true
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(requireActivity())

        builder
            .setMessage(
                Html.fromHtml(
                    String.format(
                        getString(R.string.character_creation_confirmation_message),
                        selectedName,
                        selectedClass.displayClassName()
                    )
                )
            )
            .setPositiveButton(R.string.start_adventure) { dialog, _ ->
                startAdventure()
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }

        builder.create().show()
    }

    private fun startAdventure() {
        val preferenceManager = PreferenceManager(requireContext())
        preferenceManager.characterCreated = true
    }

    private fun showErrorDialog(errorMessage: String) {
        val builder = AlertDialog.Builder(requireActivity())

        builder
            .setMessage(errorMessage)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }

        builder.create().show()
    }
}
