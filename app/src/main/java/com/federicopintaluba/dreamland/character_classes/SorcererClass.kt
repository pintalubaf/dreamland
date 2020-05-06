package com.federicopintaluba.dreamland.character_classes

import com.federicopintaluba.dreamland.character_classes.CharacterClass

class SorcererClass(
    override val startingHp: Int = 10,
    override val startingAtk: Int = 10,
    override val startingDef: Int = 10,
    override val startingSpeed: Int = 10
) : CharacterClass {
    override fun displayClassName() = "Barbarian"
}