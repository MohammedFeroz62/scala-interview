package whats_wrong

import akka.actor.Actor

import scala.concurrent.Future
import scala.util.{ Failure, Success }
import scala.concurrent.ExecutionContext.Implicits.global

/*
Do you see anything that could lead to potential problems ?-------- Answer :ExecutionContext.global is an ExecutionContext backed by a ForkJoinPool
What would you do to fix it ?                                               A general purpose ExecutionContext must be asynchronous in executing any Runnable that is passed into its execute-method. A special purpose ExecutionContext may be synchronous but must only be passed to code that is explicitly safe to be run using a synchronously executing ExecutionContext.
Do not mind about the not implemented code
*/

class WhatsWrong3 extends Actor {

  var internalState = "internal state"

  def receive: Receive = {
    case "a query" => {
      val requestF: Future[String] = queryAsyncServer()
      requestF.onComplete {
        case Success(r) => handleResponse(r)
        case Failure(e) => e.printStackTrace()
      }
    }
  }

  def handleResponse(r: String) = ??? // mutate internal state---------Answer: query("queryAsyncServer")

  def queryAsyncServer(): Future[String] = ???----------- Receive("handleResponse")
}
