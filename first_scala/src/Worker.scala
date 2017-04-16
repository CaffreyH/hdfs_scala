

import akka.actor.Actor
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSelection
import akka.actor.Props

class Worker(val masterHost: String ,val masterPort: Int ) extends Actor{

  var master: ActorSelection = _

  override def  receive:Receive = {
    case "reply" => {println("a reply from master")}

  }

  override def preStart():Unit = {
    val master = context.actorSelection(s"akka.tcp://MasterSystem@$masterHost:$masterPort/user/Master")
    master ! "connect"
  }

}

object Worker {
  def main(args: Array[String]): Unit = {
    val host = args(0)
    val port = args(1).toInt

    val masterHost = args(2)
    val masterPort = args(3).toInt

    val configStr=
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port="$port"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    println("hahahahaha")
    // ActorSystem老大，负责创建监控下面的actor, 他是单例的
    var actorSystem = ActorSystem("WorkerSystem" , config)

    // 创建actor
    var worker = actorSystem.actorOf(Props(new Worker(masterHost, masterPort)) , "Worker")

    actorSystem.awaitTermination()

  }
}