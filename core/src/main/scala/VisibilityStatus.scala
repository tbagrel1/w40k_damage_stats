package com.tbagrel1.w40kds.core

object VisibilityStatus {
  val ALWAYS_IN_COVER: UnitInstance => VisibilityStatus = _ => InCover
  val ALWAYS_NOT_IN_COVER_BUT_VISIBLE: UnitInstance => VisibilityStatus = _ => NotInCoverButVisible
  val ALWAYS_NOT_VISIBLE: UnitInstance => VisibilityStatus = _ => NotVisible
}

enum VisibilityStatus {
  case InCover extends VisibilityStatus
  case NotInCoverButVisible extends VisibilityStatus
  case NotVisible extends VisibilityStatus
}
