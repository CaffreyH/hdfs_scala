/**
  * Created by Caffrey on 2017/1/22.
  */
import scala.actors.Actor
object actor extends  Actor{
  def act(): Unit ={
    for (i <- 1 to 10)
      {
        println(s"act:act002 --- $i")
        Thread.sleep(1000)
      }
  }


}
object Main extends App{
  actor.start()
}