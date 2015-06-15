// import org.scalatest.Matchers._
// An object is a singleton.
object Greeting {
  def english = "Hi"

  def espanol = "Hola"

  def deutsch = "Hallo"

  def magyar = "Szia"
}

class ObjectTutorial {

  val x = Greeting
  val y = x
  val z = Greeting

  // (x.eq(y)) should be (true)
  // (x.eq(z)) should be (true)
}
