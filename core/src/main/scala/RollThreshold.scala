package com.tbagrel1.w40kds.core

import scala.annotation.targetName

implicit class ToRollThreshold(expected: Int) {
  @targetName("toRollThreshold")
  def ++ : RollThreshold = RollThreshold(expected)
}

case class RollThreshold(expected: Int) extends Ordered[RollThreshold] {
  def compare(that: RollThreshold): Int = this.expected.compare(that.expected)

  override def toString: String = s"${expected}+"
}

