package com.tbagrel1.w40kds.core

case class WeaponDatasheet(
                          id: String,
                          profiles: List[WeaponProfile]
                          )

case class WeaponProfile(
                        id: Option[String],
                        range: Option[Distance],
                        attacks: Amount,
                        skill: RollThreshold,
                        strength: Amount,
                        armorPen: Amount,
                        damage: Amount,
                        keywords: List[WeaponKeyword]
                        )
