import scala.collection.mutable.ArrayBuffer

/**
  * Created by Caffrey on 2017/1/20.
  */
object tupple {
  def main(args: Array[String]):Unit={
    //tupple_2()
    tupple_3()
    //array_1()
    //array_2()
    //array_3()
    //array_4()
    //mutable
  }

  def tupple_2(): Unit ={
    var t = ("a",1)
    import  scala.collection.mutable.Map
    var map =Map("a"->2,"b"->6)
    println("a"->2)
  }
  def tupple_3(): Unit ={
    var arr1 =Array(1,2,3,4)
    var arr2=Array("a","b","c","d")
    println(arr2)             //拉链操作   变成一个二元数组，
    var arr_3 = arr1.zip(arr2)
    println(arr_3.toBuffer)
  }
  def array_1(): Unit ={
    var array =new Array[Int](10)
    println(array.toBuffer)
  }

  def array_2(): Unit ={
    var arr = ArrayBuffer[Int](19,12,13 )                       //我是可变数组
    arr +=(1,2,3,4,5)
    println(arr.toBuffer)
    for( i <- 0 until  arr.size)println(arr(i))
    for( i <- 0 until  arr.length)println(arr(i))
    }

  def array_3( ): Unit ={
    var arr = Array(1,2,3,4,5)
    var arr_ = for(i <-  arr) yield i*5
    var arr_1 = arr.map( (x:Int)  => x*5 )
    var arr_2 = arr.map( _ * 5 )
    var arr_3 = arr.filter((x:Int) => x % 2 ==0)
    var arr_4 = arr.filter(x => x % 2 ==0)
    var arr_5 = arr.filter(_ % 2 ==0)               //scala 支持链式编程

    println(arr_1.toBuffer)
    println(arr_2.toBuffer)
    println(arr_.toBuffer)
    println(arr_5.toBuffer)
  }
  def array_4(): Unit ={
    var arr = Array(1,2,3,4,5)
    var arr_1 = arr.sortBy(x=> -x )
    println(arr_1.toBuffer)
    var arr2 = arr.sorted.reverse
    println(arr2.toBuffer)
    var arr3 = arr.sortWith( _ < _ )
    println(arr3.toBuffer)
  }

 //抽象  不可变集合 ，里面的数据不渴改变，新增数据后是新的集合
  def mutable(): Unit ={
    import scala.collection.mutable.Map
    var map = Map ("a"  -> 1, "b"->3)
    println(map)
    map("a") = 4
    map.++:(Set(3))
    //printf(map++:( Set (("v",3))))

    println("a")

  }

}







