package com.github.felixgail.scalatesttest

object BPlusTreeExamples extends App {
  val memoryTree = new MemoryBPlusTree[String, Any](5)

  memoryTree.insertKeys("k", "z", "p", "d", "b", "v", "h", "x", "o", "y", "c", "t", "j", "n", "f", "l", "s", "q", "i", "m", "e", "u", "w", "a", "g", "r")
  memoryTree.prettyPrint

  println(memoryTree.boundedKeysIterator(('>, "c"), ('<, "l")).mkString(", "))
  println(memoryTree.reverseKeysIterator.mkString(", "))

  println(memoryTree.height())
}
