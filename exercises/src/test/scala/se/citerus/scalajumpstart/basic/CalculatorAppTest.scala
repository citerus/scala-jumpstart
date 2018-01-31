package se.citerus.scalajumpstart.basic

import org.scalatest.FunSpec

class CalculatorAppTest extends FunSpec {

  describe("CalculatorApp") {
    it("should have tests") {
      // If you finish the main task, try to think of a way to test the
      // whole application, including input and output
    }
  }

  case class Book(title: String, isbn: String)


  describe("Matching null") {
    it("works?") {
      val book = Book("foo", "bar")
      println(book)
      val newbook = book.copy(title = "lalala")
      println("book = " + book)
      println("newbook = " + newbook)
      println(book == Book("foo", "bar"))
      println(book == newbook)

    }
  }

  def matchmaker(a: Any) = a match {
    case i: Int => "I'm an int"
    case s: String => "I'm a string"
    case None => "I'm None"
    case null => "I'm null"
    case _ => "I don't know what I am"
  }




}
