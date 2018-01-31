package se.citerus.scalajumpstart.basic
import scala.io.StdIn.readLine
import scala.util.Try

object CalculatorApp {

  def main(args: Array[String]): Unit = {
    /*
    Accumulated purchase value: 50
    Purchase amount: 100.50
    Amount to pay: 95.45
    New accumulated purchase value: 150.50
    */
    val accVal = readDecimalNumber("Accumulated purchase value: ")
    val purchaseAmount = readDecimalNumber("Purchase amount: ")

    val amtToPay = Calculator(accVal).amountToPay(purchaseAmount)
    println(s"Amount to pay: $amtToPay")
    println(s"New accumulated purchase value: ${accVal + purchaseAmount}")
  }






  def readDecimalNumber(prompt: String): BigDecimal =
    BigDecimal(readLine(prompt))

  def readPositiveNumber(prompt: String): Try[BigDecimal] =
    Try {
      val n = readDecimalNumber(prompt)
      if (n >= 0) n
      else throw new IllegalArgumentException("Amount must be >= 0")
    }

}
