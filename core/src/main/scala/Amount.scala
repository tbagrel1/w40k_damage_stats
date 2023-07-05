package com.tbagrel1.w40kds.core

import scala.annotation.targetName
import scala.language.implicitConversions

object Amount {
  val D6: Amount = Amount(1, 0, 0)
  val D3: Amount = Amount(0, 1, 0)
}

implicit class ToAmount(nb: Int) {
  def D6: Amount = Amount(nb, 0, 0)

  def D3: Amount = Amount(0, nb, 0)
}
implicit def toFixedAmount(fixed: Int): Amount = Amount(0, 0, fixed)

case class Amount(nbD6: Int, nbD3: Int, fixed: Int) {
  @targetName("add")
  def +(that: Amount): Amount = that match
    case Amount(nbD6, nbD3, fixed) => Amount(this.nbD6 + nbD6, this.nbD3 + nbD3, this.fixed + fixed)

  override def toString: String = {
    val d6Repr = nbD6 match { case 0 => ""; case 1 => "D6"; case _ => s"${nbD6}D6" }
    val d3Repr = nbD3 match { case 0 => ""; case 1 => "D3"; case _ => s"${nbD3}D3" }
    val fixedRepr = fixed match { case 0 => ""; case _ => fixed.toString }
    var res = d6Repr
    if (d3Repr.nonEmpty) { if (res.nonEmpty) { res += "+" + d3Repr } else { res += d3Repr } }
    if (fixedRepr.nonEmpty) { if (res.nonEmpty) { res += "+" + fixedRepr } else { res += fixedRepr } }
    res
  }
}

