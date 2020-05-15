package com.github.felixgail.scalatesttest

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ClassicTest extends AnyFreeSpec with Matchers {
  "An Item should return" - {
    val itemA = Item(10)

    "0 when compared with itself" - {
      itemA.compareTo(itemA) should be(0)
    }

    "a negative number when its value is smaller" - {
      val itemB = Item(20)
      itemA.compareTo(itemB) should be < 0
    }

    "a positive number when its value is bigger" - {
      val itemC = Item(0)
      itemA.compareTo(itemC) should be > 0
    }
  }
}
