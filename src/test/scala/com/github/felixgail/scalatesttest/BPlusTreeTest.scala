package com.github.felixgail.scalatesttest

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

import scala.math.{log, pow}


object BPlusTreeDataGenerator {
  type BPlusTree = MemoryBPlusTree[String, Any]

  implicit val arbTree: Arbitrary[BPlusTree] = Arbitrary(
    for {
      order <- Gen.choose(4, 128)
      keys <- Gen.listOfN(pow(order, 2).toInt, Gen.alphaNumStr)
    } yield {
      val tree = new BPlusTree(order)
      tree.insertKeys(keys: _*)
      tree
    }
  )
}

class BPlusTreeTest extends AnyFreeSpec with ScalaCheckDrivenPropertyChecks {

  import com.github.felixgail.scalatesttest.BPlusTreeDataGenerator._

  "height is less or equal to log_t((n + 1)/ 2) + 1" in forAll { (tree: BPlusTree) =>
    val t = tree.order
    val n = tree.keysIterator.size
    val h = tree.height()
    val upperBound = (log((n + 1) / 2) / log(t)) + 1
    assert(h <= upperBound)
  }
}