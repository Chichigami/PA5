package cse250.pa5

object Main {
  def main(args: Array[String]): Unit = {
    val testSize = 10

    val inputKeys = Array.tabulate(testSize)(i => i + 1)
    val inputValues = Array.tabulate(testSize)(i => i.toString * i)

    val treeMap = new AVLTreeMap[Int, String]
    val hashMap = new HashTableMap[Int, String]
    for (elem <- inputKeys.zip(inputValues)) {
      treeMap.addOne(elem)
      hashMap.addOne(elem)
    }

    println(treeMap)
    println(hashMap)
  }
}
