
import akka.actor.{Actor }
import akka.actor.Actor.Receive
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

class Master extends Actor{

  println("constructor invoked ")

  override def preStart(): Unit = {
    println("preStart invoked")
  }

  def receive(): Receive ={
    case "connect" => {
      println("a client connected")
      sender ! "reply"
    }
    case "hello" => {
      println("hello")
    }
  }
}

object Master {

  def main(args: Array[String]): Unit = {
    val host = args(0)
    val port = args(1).toInt
    val configStr=
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port="$port"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    println("hahahahaha")
    // ActorSystem老大，负责创建监控下面的actor, 他是单例的
    var actorSystem = ActorSystem("MasterSystem" , config)

    // 创建actor
    var master = actorSystem.actorOf(Props[Master] , "Master")

    master ! "hello"

    actorSystem.awaitTermination()


  }
}