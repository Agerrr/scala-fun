abstract class Buffer {
  // T is an abstract type
  type T
  val element: T
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U] // T must be a subtype of Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}
object AbstractTypeTest1 extends Application {
  def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
    new IntSeqBuffer {
      type T = List[U]
      val element = List(elem1, elem2)
    }
    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
}

/*
 * Version of the code where abstract type members are type parameters.
 */
abstract class Buffer2[+T] {
  val element: T
}

abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
  def length = element.length
}
object AbstractTypeTest2 extends Application {
  def newIntSeqBuf2(e1: Int, e2: Int): SeqBuffer2[Int, Seq[Int]] =
    new SeqBuffer2[Int, List[Int]] {
      val element = List(e1, e2)
    }
    val buf = newIntSeqBuf2(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
}