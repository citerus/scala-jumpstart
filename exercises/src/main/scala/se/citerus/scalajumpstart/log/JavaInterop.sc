import scala.beans.BeanProperty

case class Foo(@BeanProperty var name: String) {
}

Foo("Johan").name = "Olle"

// Without BeanProperty from Java:
// new Foo("Johan").name().equals("Johan")
// new Foo("Johan").name_=("Olle")

// With BeanProperty from Java
// new Foo("Johan").getName().equals("Johan")
// new Foo("Johan").setName("Olle")

object Bar {
  private[this] val constant = 15

  def computeSomething(): Int = {
    var x = 0
    for (i <- 1 to 1000000) {
      x += constant
    }
    x
  }
}


// Generated access code (from Java): Bar$.constant()