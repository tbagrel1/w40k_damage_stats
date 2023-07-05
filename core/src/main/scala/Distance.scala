package com.tbagrel1.w40kds.core

implicit class ToDistance(range: Double) {
  def toRange: Distance = Distance(range)
}

case class Distance(inches: Double)
