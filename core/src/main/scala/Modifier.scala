package com.tbagrel1.w40kds.core

implicit class ToModifier(value: Int) {
  def modFrom(source: Source): Modifier = Modifier(value, source)
}

case class Modifier(value: Int, source: Source) {
  override def toString: String = {
    s"MOD ${if (value > 0) { "+" } else { "" }}${value} (${source})"
  }
}
