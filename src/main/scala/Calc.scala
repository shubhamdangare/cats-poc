

object Calc extends App {

  println("what operation to do : ")
  val enterOption = scala.io.StdIn.readLine()
  println("Enter two numbers : ")
  val firstNumber = scala.io.StdIn.readLine().toInt
  val secondNumber = scala.io.StdIn.readLine().toInt

  enterOption match {
    case "ADD" => add(firstNumber, secondNumber)

    case "SUB" => sub(firstNumber, secondNumber)

    case "DIV" => div(firstNumber, secondNumber)

    case "MUL" => mul(firstNumber, secondNumber)
  }


  private def add(firstNumber: Int, secondNumber: Int) = print(firstNumber + secondNumber)

  private def sub(firstNumber: Int, secondNumber: Int) = print(firstNumber - secondNumber)

  private def mul(firstNumber: Int, secondNumber: Int) = print(firstNumber * secondNumber)

  private def div(firstNumber: Int, secondNumber: Int) = print(firstNumber /  secondNumber)


}

