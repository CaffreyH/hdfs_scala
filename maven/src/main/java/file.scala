import java.io.File
import java.util.concurrent.{Executor, Executors}

import scala.io.Source

/**
  * Created by Caffrey on 2017/1/22.
  */
object file extends App{
  try{
    var file = new File("D:\\mycode_intelleJ\\maven\\src\\main\\java\\MyActor.scala")
    println (Source.fromFile(file).mkString)
}
  catch{
  case t:Exception => t.printStackTrace()
  case _ => println("1")
}

val pool = Executors.newFixedThreadPool(5)
for(i <- 1 to 10) {
  pool.execute(new Runnable {
    override def run() = {
      println(Thread.currentThread().getName)
      Thread.sleep(100)
    }
  })
}
}