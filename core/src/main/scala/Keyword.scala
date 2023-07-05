package com.tbagrel1.w40kds.core

enum WeaponKeyword(id: String, desc: String) extends Keyword(id, desc) {
  case ASSAULT extends WeaponKeyword("ASSAULT", "")
  case RAPID_FIRE(amount: Amount) extends WeaponKeyword(s"RAPID FIRE ${amount}", "")
  case IGNORE_COVER extends WeaponKeyword("IGNORE COVER", "")
  case TWIN_LINKED extends WeaponKeyword("TWIN-LINKED", "")
  case PISTOL extends WeaponKeyword("PISTOL", "")
  case TORRENT extends WeaponKeyword("TORRENT", "")
  case LETHAL_HITS extends WeaponKeyword("LETHAL HITS", "")
  case LANCE extends WeaponKeyword("LANCE", "")
  case INDIRECT_FIRE extends WeaponKeyword("INDIRECT FIRE", "")
  case PRECISION extends WeaponKeyword("PRECISION", "")
  case BLAST extends WeaponKeyword("BLAST", "")
  case MELTA(amount: Amount) extends WeaponKeyword(s"MELTA ${amount}", "")
  case HEAVY extends WeaponKeyword("HEAVY", "")
  case HAZARDOUS extends WeaponKeyword("HAZARDOUS", "")
  case DEVASTATING_WOUNDS extends WeaponKeyword("DEVASTATING WOUNDS", "")
  case SUSTAINED_HITS(amount: Amount) extends WeaponKeyword(s"SUSTAINED HITS ${amount}", "")
  case EXTRA_ATTACKS(amount: Amount) extends WeaponKeyword(s"EXTRA ATTACKS ${amount}", "")
  case ANTI(targetKw: DatasheetKeyword, rollTh: RollThreshold) extends WeaponKeyword(s"ANTI-${targetKw} ${rollTh}", "")
  case ONE_SHOT extends WeaponKeyword("ONE-SHOT", "")
}

enum DatasheetKeyword(id: String, desc: String) extends Keyword(id, desc) {
  case VEHICLE extends DatasheetKeyword("VEHICLE", "")
  case MONSTER extends DatasheetKeyword("MONSTER", "")
  case INFANTRY extends DatasheetKeyword("INFANTRY", "")
  case BEAST extends DatasheetKeyword("BEAST", "")
  case CHARACTER extends DatasheetKeyword("CHARACTER", "")
  case LONE_OPERATIVE extends DatasheetKeyword("LONE OPERATIVE", "")
  case LEADER extends DatasheetKeyword("LEADER", "")
}
sealed abstract class Keyword(val id: String, val desc: String)