package com.federicopintaluba.dreamland.character_classes

class BarbarianClass(
    override val startingHp: Int = 145,
    override val startingAtk: Int = 12,
    override val startingDef: Int = 10
) : CharacterClass {
    override fun className() = CharacterClassName.BARBARIAN
}