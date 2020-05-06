package com.federicopintaluba.dreamland.character_classes

class SorcererClass(
    override val startingHp: Int = 135,
    override val startingAtk: Int = 14,
    override val startingDef: Int = 6,
    override val startingSpeed: Int = 10
) : CharacterClass {
    override fun displayClassName() = "Sorcerer"
}