package com.tbagrel1.w40kds.core

import scala.annotation.targetName

implicit class ToRollPredicate(expected: RollThreshold) {
  @targetName("toRollPredicate")
  def /(amount: Amount): RollPredicate = RollPredicate(expected.expected, amount)
}

case class RollPredicate(expected: Int, amount: Amount) {
  override def toString: String = { s"${expected}+/${amount}" }
}
