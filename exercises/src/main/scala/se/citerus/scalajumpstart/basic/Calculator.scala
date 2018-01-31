package se.citerus.scalajumpstart.basic

import scala.util.{Failure, Success, Try}

case class Calculator(accumulatedValue: BigDecimal) {
  val discountLimit: BigDecimal = 100
  val discountPercentage: BigDecimal = 10

  def amountToPay(value: BigDecimal): BigDecimal =
    if (accumulatedValue + value <= discountLimit) value
    else if (accumulatedValue >= discountLimit) discount(value)
    else {
      val rebated = value - (discountLimit - accumulatedValue)
      (value - rebated) + discount(rebated)
    }

  private def discount(value: BigDecimal) = {
    value * (100 - discountPercentage) / 100
  }

  def assertIsPositive(i: Int): Int =
    if (i < 0) throw new IllegalArgumentException("bleh")
    else i

  def checkValue(i: Int): Try[Int] =
    if (i < 0) Failure(new IllegalArgumentException("bleh"))
    else Success(i)

  def checkValue2(i: Int): Try[Int] = Try(assertIsPositive(i))

  val t: Try[Int] = checkValue(5)

  t match {
    case Success(v) => println(s"I got $v")
    case Failure(f) => println(s"Got an exception: $f")
  }

}



