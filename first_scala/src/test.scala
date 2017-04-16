import scala.collection.GenTraversableOnce

/**
  * Created by Caffrey on 2017/1/20.
  */
object test {
  def main(args:Array[String]): Unit ={
    test1
  }

  def test1: Unit ={
    val lst = List(1,7,9,8,0,3,5,4,6,2)
    val lst1 = lst.map(_*10)                   //每个元素×10
    println(lst1)
    val lst2 = lst.filter( (x:Int) => x % 2 == 0 )
    println(lst2)
    val lst2_2= lst.map(x => if (x%2 == 0) x  else 0)
    println(lst2_2)
    val lst3 = lst.sortWith( _ < _ )         //排序的三种方式
    val lst3_2 = lst.sorted
    val lst3_3 = lst.sortBy(x=>x)
    println(lst3,lst3_2,lst3_3)
    val lst4 = lst.sorted.reverse         //反序
    println(lst4)
    val lst5 = lst.splitAt(4)             //前4个一组
    val lst5_1= lst.grouped(4)            //每4个分为一组
    println(lst5,lst5_1)
    val it: Iterator[List[Int]]=lst.grouped(4)      //创建迭代器
    println(it.toBuffer)
    val lst6 = it.toList                            //转换成list
    println(lst6)
    val lst7 = List(lst,lst1).flatten               //压扁成一个
    println(lst7)

    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    val lines1_1 = lines.map(_.split("")).flatten
    val lines1_2 = lines.map(_.split(" ")).flatten
    println(lines1_1,lines1_2)
    val lines2 = lines.toString().split(" ")
    println(lines2.toBuffer)
    val lines3 = List(lines).flatten
    println(lines3)
    val lines4 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))        //统计单词个数
    val lines4_1 = lines.flatMap(_.split(" ")).groupBy(x=> x).map(x => (x._1,x._2.size)).toList.sortBy(x=> x._2 ).reverse
    println(lines4,lines4_1)
    val lines5 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t=>(t._1, t._2.size)).toList.sortBy(_._2).reverse
    println(lines5)

    val list = List(("hello",4),("hello",2),("hello",1),("hello",1))
    println(list.foldLeft(0)(_ + _._2))
    val  lines6 = lst.sum
    println(lines6)
    println(lst.par.sum)
    println(lst.par.fold(3)(_+_))        //无顺序      折叠  有初始值，无特定顺序
    println(lst.par.foldLeft(3)(_+_))    //特定顺序
    println(lst.reduce(_+_))            //化简reducce
    println(lst.par.fold(3)(_+_))       //  折叠 有初始值，无特定顺序，并行
    println(lst.par.foldLeft(3)(_+_))       //折叠 有初始值，有特定顺序，不并行

    //聚合
    val arr = List(List(1, 2, 3), List(3, 4, 5), List(2), List(0))
    println(arr.flatten.fold(0)(_+_))     //压扁折叠方法
    println(arr.aggregate(0)(_+_.sum,_+_) )             //  首先将array转换为一个新的list，list(6,12,2,0)，后面的函数处理的是第一个函数处理完的结果

    val l1 = List(5,6,4,2)
    val l2 = List(1,2,3,4)
    //求并集
    println(l1 union l2)
    //求交集
    println(l1 intersect  l2)
    //求差集
    println(l1 diff l2)


    val nums = List(1,2,3)
    val sum1 = nums.reduce((a,b) => a+b)   //6
    val sum2 = nums.reduce(_+_)            //6
    println(sum1,sum2)

    val nums2 = List(2.0,2.0,3.0)
    val resultLeftReduce = nums2.reduceLeft(math.pow)  // = pow( pow(2.0,2.0) , 3.0) = 64.0
    val resultRightReduce = nums2.reduceRight(math.pow) // = pow(2.0, pow(2.0,3.0)) = 256.0
    println(resultLeftReduce,resultRightReduce)
  }

}
