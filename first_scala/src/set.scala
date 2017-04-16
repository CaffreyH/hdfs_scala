/**
  * Created by Caffrey on 2017/1/20.
  */
object set {
  def main(args : Array[String]): Unit ={
    //immutable_set()
    mutable_set()
  }

  def immutable_set ():Unit={
  import scala.collection.immutable.HashSet     //不可变的集合
    val set = new HashSet[Int]()
    val set_1=set+4
    println(set,set_1)
    val set_2=set ++ Set(1,3,4 )
    val set_4=Set(1,2,3)++Set(1,3,4)
    println(set_2,set_4,set)            //set 是集合，其中的内容不会重复
  }

  def mutable_set(): Unit =
  {
    import scala.collection.mutable.HashSet
    val set=new HashSet[Int]()
    set +=2
    println(set)
    set.add(3)
    set++=Set(3,4,5)
    println(set)
    set-=5
    println(set)
    set.remove(2)
    println(set)

  }
}
