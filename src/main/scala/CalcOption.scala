import CalcFuture.TypeError
import cats.data.EitherT
import cats._
import implicits._

import scala.concurrent.{ExecutionContext, Future}


class CalcOption {

  implicit val ec: ExecutionContext = ExecutionContext.global

  val list = List(2, 4, 5, 6)
  val emptyList = List()

  private def add(list: List[Int]): Option[Int] = {

    if (list.isEmpty)
      None
    else
      Some(list.sum)
  }


  val addOfList: EitherT[Future, TypeError.Empty.type, Int] = for {
    data <- EitherT.fromOption[Future](add(list), TypeError.Empty)
  } yield data


  val addOfListSec = for {
    dataa <- EitherT.right(add(list))
  } yield dataa

  println(addOfList)

  println(addOfListSec)

  print("hello there")

}

object CalcOption extends App {

  val cobj = new CalcOption()

  sealed trait TypeError

  object TypeError {

    case object NotNumber extends TypeError

    case object Empty extends TypeError

  }

}



