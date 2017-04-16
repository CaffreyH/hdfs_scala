package test

object OptionDemo extends App{
  
  val map = Map("a"-> 1 ,"b" -> 2)
  
  map.get("a")
  
  val value = map.get("a") match {
    case Some(a) => a
    case None => 0
  }
  
  map.getOrElse("a", 10)
}