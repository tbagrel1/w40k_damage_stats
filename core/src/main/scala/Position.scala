package com.tbagrel1.w40kds.core

case class Position(x: Double, y: Double) {
  def distanceTo(other: Position): Distance = {
    val dx = other.x - x
    val dy = other.y - y
    Distance(math.sqrt(dx * dx + dy * dy))
  }
}

