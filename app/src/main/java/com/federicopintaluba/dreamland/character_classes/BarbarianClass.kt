package com.federicopintaluba.dreamland.character_classes

class BarbarianClass(
    override val startingHp: Int = 10,
    override val startingAtk: Int = 10,
    override val startingDef: Int = 10,
    override val startingSpeed: Int = 10
) : CharacterClass {
    override fun displayClassName() = "Barbarian"
}