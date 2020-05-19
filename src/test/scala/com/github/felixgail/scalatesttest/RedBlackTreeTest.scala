package com.github.felixgail.scalatesttest

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import scala.math.{log}


object RedBlackTreeDataGenerator {
  type RBTree = RedBlackTree[String, Any]
  type RBTNode = RBT[String, Any]

  implicit val arbTree: Arbitrary[RBTree] = Arbitrary(
    for {
      keys <- Gen.listOfN(1024, Gen.alphaNumStr)
    } yield RedBlackTree.apply(keys.zipWithIndex: _*)
  )
}

class RedBlackTreeTest extends AnyFreeSpec with ScalaCheckDrivenPropertyChecks {

  import com.github.felixgail.scalatesttest.RedBlackTreeDataGenerator._

  "height is less or equal to 2 * log2(n + 1)" in forAll { (rbTree: RBTree) => {
    val n = rbTree.count(rbTree.tree)
    val maxHeight = 2 * log(n + 1) / log(2)
    val height = rbTree.height(rbTree.tree)

    assert(height <= maxHeight)
  }}
}