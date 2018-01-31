import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val future: Future[Int] = Future {
  println("Future started")
  Thread.sleep(1000)
  println("Future done!")
  17
} (global) // <- you can specify execution context, but don't have to

case class DatabaseObject(id: String, number: Int)

def fetchFromDatabase(): Future[DatabaseObject] = ???

def transformToJsonString(db: DatabaseObject): String = ???

def askExternalService(request: String): Future[String] = ???

val reply: Future[String] = for {
  dbobject <- fetchFromDatabase()
  json = transformToJsonString(dbobject)
  reply <- askExternalService(json)
} yield reply

val otherReply: Future[String] =
  fetchFromDatabase().flatMap { dbobject =>
  askExternalService(transformToJsonString(dbobject))
}

