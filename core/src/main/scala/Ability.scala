package com.tbagrel1.w40kds.core

enum DatasheetAbility(id: String, desc: String) extends Ability(id, desc) {
  case FEEL_NO_PAIN(n: Int) extends DatasheetAbility(s"Feel no pain ${n}+", "")
}

abstract class Ability(val id: String, desc: String)
