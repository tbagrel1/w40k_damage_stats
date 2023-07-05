package com.tbagrel1.w40kds.core

enum MovementStatus {
  case NormalMove extends MovementStatus
  case Advance extends MovementStatus
  case RemainStationary extends MovementStatus
  case FallBack extends MovementStatus
}
