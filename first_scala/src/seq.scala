import scala.collection.mutable.ListBuffer

/**
  * Created by Caffrey on 2017/1/20.
  */
object seq {
  def main(args: Array[String])
  {
    //immutableSeq()
    mutableSeq()
  }
//  :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
//  :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
//  ++ 该方法用于连接两个集合，list1++list2
//  ::: 该方法只能用于连接两个List类型的集合
  def immutableSeq(): Unit =
  {
    var list=List(1,2,3,4,5,6)
    list(2)
    import scala.collection.mutable.ListBuffer
    val lb = ListBuffer(1,2,3)
    lb(1)=200
    println(lb)
    val lb_1=lb.map(_ *10)                      //List 不可以更改  listbuffer  可以更改
    println(lb_1,lb)
  }

  def mutableSeq(): Unit ={
    val list = List (1,2,3,4,5)
    val list_1 = 0::list  //:: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否
    val list_2 = list.::(0)
    val list_3 = list_1:::list_2
    val list_4 = list_1 ++ list_2
    println(list,list_1,list_2,list_3,list_1.sum,list_1.size,list_4)
  }

  def immutableSeq2(): Unit ={

    //import scala.collection.mutable.L
    var list = List (1,2,3,4)
    //list(2)=10
  }


}
