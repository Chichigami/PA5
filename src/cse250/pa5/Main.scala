package cse250.pa5

object Main {
  def main(args: Array[String]): Unit = {
    println("Andrew".hashCode())
    println("Andrew".hashCode())
    println("Miren".hashCode())
    println("michael".hashCode())
    println("brian".hashCode())
    println("frank".hashCode())
    println("gary".hashCode())
    println("james".hashCode())
    println("nafin".hashCode())
    val hashMap = new HashTableMap[String, String]
    hashMap.addOne(("Andrew","hugh"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("Miren","patel"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("michael","tran"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("Andrew","qu"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("gary","guy"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("Andrew", "Zhu"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("gary","snail"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("james","mcgrath"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("frank","yang"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("brian","chen"))
    println(hashMap.bucketArray.length)
    hashMap.addOne(("nafin","nevermethim"))
    println(hashMap.bucketArray.length)
    val iteratoratorer = hashMap.iterator
    for (elem <- iteratoratorer){
      println(elem)
    }
  }
}
