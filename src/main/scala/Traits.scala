class Traits {
  var sb = List[String]()

  trait T1 {
    sb = sb :+ "In T1: x=%s".format(x)
    val x = 1
    sb = sb :+ "In T1: x=%s".format(x)
  }

  class C1 extends T1 {
    val y = 2
    sb = sb :+ "In C1: y=%s".format(y)
  }

  sb = sb :+ "Creating C1"
  new C1
  sb = sb :+ "Created C1"
}
