package com.federicopintaluba.dreamland.character_classes

interface CharacterClass {
    val startingHp: Int
    val startingAtk: Int
    val startingDef: Int
    val startingSpeed: Int
    fun displayClassName(): String
}