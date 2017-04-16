import scala.actors.Actor

/**
  * Created by Caffrey on 2017/1/22.
  */
class MyActor extends Actor {

  def act(): Unit = {
    while (true) {
      receive {
        case "start" => {
          println("1 starting.......")
          Thread.sleep(1000)
          printf("1 started")
          println(Thread.currentThread().getName)
          sender ! " 线程 1 开始"       //一定要回复，否则会一直等待
        }

        case "stop" => {
          println("1 stoping......")
          Thread.sleep(1000)
          println("1 stoped.")
          sender ! " 线程 1 结束"
        }
      }
    }
  }
}
class yourActor extends Actor{
  override def act(): Unit = {
    loop{
      react{
        case "start" => {
          println("2 starting...")
          Thread.sleep(1000)
          println(Thread.currentThread().getName)
          println("2 starting...")
          sender ! "2 start is ok"
        }
        case "stop" => {
          println("2 stoping...")
          Thread.sleep(1000)
          println(Thread.currentThread().getName())
          println("2 stoped...")
        }
        case "exit"=>{
          println("2 exit")
          exit()
        }
      }
    }
  }
}

object MyActor extends App{
  val actor = new MyActor
  actor.start()
  val reply =actor !? "start"
  println(reply)
  println("!?")
  Thread.sleep(1000)
  val reply2 = actor !? "stop"
  println(reply2)
  println("Message has been send")

  val actor1_2 = new MyActor
  actor1_2.start()
  val reply1_2 =actor1_2 !? "start"
  println(reply1_2)
  println("!?")
  Thread.sleep(1000)
  val reply21_2 = actor1_2 !? "stop"
  println(reply21_2)
  println("Message has been send")

  val actor2 = new yourActor
    actor2.start()
    var i = actor2 !? "start"
    println("i")
    actor2 ! "exit"

}