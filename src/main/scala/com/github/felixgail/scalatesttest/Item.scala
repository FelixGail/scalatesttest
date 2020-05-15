package com.github.felixgail.scalatesttest

sealed trait Orderable[T] {
  def compareTo(other: T): Int
}

case class Item(value: Int) extends Orderable[Item] {
  override def compareTo(other: Item): Int = {
    if (this.value < other.value) {
      return -1
    } else if (this.value > other.value) {
      return 1
    }
    0
  }
}
