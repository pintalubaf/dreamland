package com.federicopintaluba.dreamland.character_classes

interface CharacterClass {
    val startingHp: Int
    val startingAtk: Int
    val startingDef: Int
    fun className(): String
}