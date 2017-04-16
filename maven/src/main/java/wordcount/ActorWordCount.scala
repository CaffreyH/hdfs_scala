package wordcount
import scala.actors.{Actor ,Future}
import scala.io.Source
import scala.collection.mutable.HashSet
import scala.collection.mutable.ListBuffer

case class SubmitTask(filename:String)
case class ResultTask(map : Map[String, Int])
case object StopTask
class Task extends Actor{
  
  def act():Unit={
    loop{
      react{
        case SubmitTask(filename) => {
          val result = Source.fromFile(filename).getLines().flatMap(_.split(" ")).map((_, 1))
          .toList.groupBy(_._1).mapValues(_.size)
          sender ! ResultTask(result)
        }
        case StopTask => exit()
      }
    }
  }
}

object ActorWordCount extends App{
  
  val replySet =new  HashSet[Future[Any]]()
  val resultList = new ListBuffer[ResultTask]()
  val files = Array[String]("D:\\mycode_intelleJ\\maven\\src\\main\\java\\wordcount\\words")
  for (f <- files){
    val actor = new Task
    val reply = actor.start() !! SubmitTask(f)
    replySet += reply
  }
  
  while(replySet.size > 0){
    val toCompute = replySet.filter(_.isSet)
    for(f <- toCompute){
      val resulttask = f().asInstanceOf[ResultTask]
      resultList +=resulttask
      replySet -= f
    }
    
    Thread.sleep(100)
  }
  
  //汇总功能
  //List(Map(),Map(),Map())
  var fr = resultList.flatMap(_.map).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
  println(fr)
  
}