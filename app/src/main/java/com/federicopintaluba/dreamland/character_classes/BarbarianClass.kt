package com.federicopintaluba.dreamland.character_classes

class BarbarianClass(
    override val startingHp: Int = 135,
    override val startingAtk: Int = 12,
    override val startingDef: Int = 10,
    override val startingSpeed: Int = 8
) : CharacterClass {
    override fun displayClassName() = "Barbarian"
}