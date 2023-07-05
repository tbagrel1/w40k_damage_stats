package com.tbagrel1.w40kds.core

import com.tbagrel1.w40kds.core.Amount._

import scala.annotation.targetName

@main
def main(): Unit = {
  val a: Amount = 2
  println(s"Hello world!, ${2.++ / D6}, ${5.++ / 2.D6}, ${4.++ / 12}, ${a}")
}