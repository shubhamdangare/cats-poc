import CalcFuture.TypeError
import cats.data.EitherT
import cats._
import implicits._

import scala.concurrent.{Await, ExecutionContext, Future}

class CalcFuture {
  implicit val ec: ExecutionContext  = ExecutionContext.global

  val list = List(2, 4, 5, 6)
  val emptyList = List()

  private def add(list: List[Int]): Either[TypeError, Int] = {

    if (list.isEmpty)
      TypeError.Empty.asLeft
    else
      list.sum.asRight
  }



 val addOfList: EitherT[Future, TypeError, Int] =  for(
    data <- EitherT.fromEither[Future](add(emptyList))
  )yield data

   val data = addOfList.value.flatMap {
    case Left(_) => Future.successful(print("error"))
    case Right(value) => Future.successful(print("Addition is " ,value))
  }

  print("hello there")

  private def sub(firstNumber: Int, secondNumber: Int) = print(firstNumber - secondNumber)

  private def mul(firstNumber: Int, secondNumber: Int) = print(firstNumber * secondNumber)

  private def div(firstNumber: Int, secondNumber: Int) = print(firstNumber / secondNumber)


}

object CalcFuture  extends  App{

  val cobj = new CalcFuture()




  sealed trait TypeError

  object TypeError {

    case object NotNumber extends TypeError

    case object Empty extends TypeError

  }

}


