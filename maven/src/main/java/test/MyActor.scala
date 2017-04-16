package test

import actors.Actor
class MyActor extends Actor{
  
  def act(){
    while(true){
//      println(1234545)
      receive{
        case "start" => {
          println("starting ....... ")
          Thread.sleep(5000)
          println("started")
        }
        
        case "stop" => {
          println("stopping ....... ")
          Thread.sleep(5000)
          println("stopped .........")
        }
      }
    }
  }
}

class YourActor extends Actor{
  
  def act(): Unit={
    loop{
      react{ // 复用线程池
        case "start" => {
          println("starting ....... ")
          Thread.sleep(5000)
          println(Thread.currentThread().getName)
          println("started")
        }
        
        case "stop" => {
          println("stopping ....... ")
          Thread.sleep(5000)
          println(Thread.currentThread().getName)
          println("stopped .........")
        }
        case "exit" =>{
          println("exit")
          exit()
        }
      }
    }
  }
}


object MyActor extends App{
  
  val actor = new MyActor
  actor.start()
  
  actor ! "start"
  actor ! "start"
  actor ! "start"
  actor ! "stop"
  println("消息发送完毕")
  
  val yourActor = new YourActor
//  yourActor.start()
  
//  var i = yourActor !? "start"
//  yourActor ! "exit"
  
}