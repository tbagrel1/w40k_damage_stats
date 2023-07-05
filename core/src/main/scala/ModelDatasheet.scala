package com.tbagrel1.w40kds.core

case class ModelDatasheet(
                        name: String,
                        move: Distance,
                        toughness: Amount,
                        normalSave: RollThreshold,
                        rangedInvulnSave: Option[RollThreshold],
                        meleeInvulnSave: Option[RollThreshold],
                        initialWounds: Amount,
                        leadership: RollThreshold,
                        objectiveControl: Amount,
                        factionKeyword: DatasheetKeyword,
                        subfactionKeyword: Option[DatasheetKeyword],
                        otherKeywords: List[DatasheetKeyword],
                        meleeWeapons: List[WeaponDatasheet],
                        rangedWeapons: List[WeaponDatasheet],
                        coreAbilities: List[Ability],
                        factionAbilities: List[Ability],
                        otherAbilities: List[Ability]
                        ) {
  def datasheetKeywords: List[DatasheetKeyword] = {
    List(factionKeyword) ++ subfactionKeyword.toList ++ otherKeywords
  }

  def abilities: List[Ability] = {
    coreAbilities ++ factionAbilities ++ otherAbilities
  }

  def id: String = {
    factionKeyword.toString + " / " + name
  }
}
