package com.federicopintaluba.dreamland.navigation.welcome

import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_character_creation.*

class CharacterCreationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_character_creation, container, false)

    var selectedClass: CharacterClass =
        BarbarianClass()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setCharacterClassSelectorListeners()
        setCreateCharacterButtonListener()
    }

    private fun setCharacterClassSelectorListeners() {
        class_barbarian_radio.setOnClickListener {
            character_class_description.text = getString(R.string.barbarian_description)
            selectedClass = BarbarianClass()
        }

        class_ranger_radio.setOnClickListener {
            character_class_description.text = getString(R.string.ranger_description)
            selectedClass = RangerClass()
        }

        class_sorcerer_radio.setOnClickListener {
            character_class_description.text = getString(R.string.sorcerer_description)
            selectedClass = SorcererClass()
        }
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

        return true
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(requireActivity())

        builder
            .setMessage(
                String.format(
                    getString(R.string.character_creation_confirmation_message),
                    "Name",
                    "Class"
                )
            )
            .setPositiveButton(R.string.start_adventure) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }

        builder.create().show()
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
