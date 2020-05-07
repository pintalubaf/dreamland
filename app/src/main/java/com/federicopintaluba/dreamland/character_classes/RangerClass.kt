package com.federicopintaluba.dreamland.character_classes

class RangerClass(
    override val startingHp: Int = 135,
    override val startingAtk: Int = 10,
    override val startingDef: Int = 8,
    override val startingSpd: Int = 12
) : CharacterClass {
    override fun className() = CharacterClassName.RANGER
}