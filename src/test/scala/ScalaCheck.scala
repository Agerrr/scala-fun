import org.scalacheck._
import Prop.forAll

/*
 * To run the tests: sbt test (from scala-fun)
 */

/*
 * Example specification.
 */ 
object StringSpecification extends Properties("String") {

  property("startsWith") = forAll { (a: String, b: String) =>
    (a+b).startsWith(a)
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a+b+c).substring(a.length, a.length+b.length) == b
  }
}