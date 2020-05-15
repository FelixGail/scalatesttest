package com.github.felixgail.scalatesttest

import org.scalatest.exceptions.DiscardedEvaluationException
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class PropTest extends AnyFreeSpec with ScalaCheckDrivenPropertyChecks with Matchers {

  "Order" - {
    "should be transitive" in {
      forAll { (a: Int, b: Int, c: Int) =>
        val itemA = Item(a)
        val itemB = Item(b)
        val itemC = Item(c)

        (itemA.compareTo(itemB), itemB.compareTo(itemC)) match {
          case (1, 1) => itemA.compareTo(itemC) should be(1)
          case (-1, -1) => itemA.compareTo(itemC) should be(-1)
          case (0, 0) => itemA.compareTo(itemC) should be(0)
          case (_, _) => throw new DiscardedEvaluationException
        }
      }
    }
  }
}
