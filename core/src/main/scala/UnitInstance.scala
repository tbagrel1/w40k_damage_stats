package com.tbagrel1.w40kds.core

case class ModelGroup(datasheet: ModelDatasheet, initialNb: Int, var currentNb: Int = -1, var currentWounds: Amount = null) {
  if (currentNb == -1) {
    currentNb = initialNb
  }
  if (currentWounds == null) {
    currentWounds = datasheet.initialWounds
  }

  def prepareAndCheckDead(): Boolean = {
    if (currentNb >= 1 && currentWounds.fixed <= 0) {
      currentWounds = datasheet.initialWounds;
      currentNb -= 1
      println(s"Model ${datasheet.name} no.${(initialNb - currentNb + 1)} died")
    }
    currentNb <= 0
  }

  override def toString: String = {
    s"${initialNb} x ${initialNb}"
  }
}

// TODO: are attacks lost when the bodyguard dies and leader seperates from the unit?

case class UnitInstance(
                         var name: String,
                         var enablePrecision: Boolean,
                         var enableSHFishing: Boolean,
                         var enableOneShotWeapons: Boolean,
                         var visibilityStatusFrom: UnitInstance => VisibilityStatus,
                         var movementStatus: MovementStatus,
                         var position: Position,
                         var isBattleShocked: Boolean,
                         var models: List[ModelGroup],
                         var leaderOpt: Option[UnitInstance],
                         var leaderSubsumeCount: Int = 0,
                         var currentModelIdx: Int = 0
                       ) {

  def visibilityStatusTo(other: UnitInstance): VisibilityStatus = {
    other.visibilityStatusFrom(this)
  }

  private def leaderSubsume(): Boolean = {
    val leader = leaderOpt.get
    name = s"${leader.name} [Previously ${name}]"
    println(s"Unit ${name} got subsumed by its leader ${leader.name}")
    enablePrecision = leader.enablePrecision
    enableSHFishing = leader.enableSHFishing
    enableOneShotWeapons = leader.enableOneShotWeapons
    // keep visibilityStatusFrom from base unit
    // keep movementStatus from base unit
    // keep position from base unit
    // keep isBattleShocked from base unit TODO
    models = leader.models
    leaderOpt = leader.leaderOpt
    leaderSubsumeCount = leaderSubsumeCount + leader.leaderSubsumeCount + 1
    currentModelIdx = leader.currentModelIdx
    prepareAndCheckDead()
  }

  def prepareAndCheckDead(): Boolean = {
    if (currentModelIdx < models.length && models(currentModelIdx).prepareAndCheckDead()) {
      println(s"Model group ${models(currentModelIdx).toString} died")
      currentModelIdx += 1
    }
    if (currentModelIdx >= models.length && leaderOpt.isDefined) {
      val leader = leaderOpt.get
      if (!leader.prepareAndCheckDead()) {
        return leaderSubsume()
      }
    }
    if (currentModelIdx >= models.length) {
      println(s"Unit ${name} died")
      true
    } else {
      false
    }
  }

}
