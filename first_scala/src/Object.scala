/**
  * Created by Caffrey on 2017/1/19.
  */
object Object {
  def main(args: Array[String]):Unit=
  {
    println("sa")
  //-------------------数据类型
    val byte : Byte=127
    //一个字节
    val short :Short=23
    val char :Char='a'
  //两个字节
    val int :Int=1
    val float :Float=1
    //4
    val long :Long=1
    val double :Double=1
    //8

    //------------------数据类型
    val string: String="a"
    val a = null
    val boolean:Boolean=true
    //boolean  null  string

    val any: Any=12
    val anyVal: AnyVal="huha"
    val anyVal2:AnyVal=true
//    val anyRef: AnyRef=false          //不可以
    val anyRef2:AnyRef=null
    val anyRef3:AnyRef=new Array[Int](3)
    var unit : Unit = 232
    val anyref_1: AnyRef = new Array[Double](14)
    println(anyVal)
    println(unit)
    //any   anyVal  数值   //anyRef  引用

    def tupple_L () {
      ///通过第几个来访问
      var tupple = (1, 3, 5, 7) ///可以存放不同类型的值
      //println(tupple)
     // println(tupple, _2)

    }
    def aa ():Unit={
      5
    }
    println(aa())
  }


}
