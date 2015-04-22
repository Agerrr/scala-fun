class ScalaFun {

  def sum(list: List[Int]): Int = list.foldLeft(0)((r, c) => r + c)

  def product(list: List[Int]): Int = list.foldLeft(1)(_*_)

  def count(list: List[Any]): Int = list.foldLeft(0)((sum,_) => sum + 1)

  def average(list: List[Double]): Double = list.foldLeft(0.0)(_+_) / list.foldLeft(0.0)((sum,_) => sum + 1)

  //def average2(list: List[Double]): Double = list match {
  //  case head :: tail => tail.foldLeft((head, 1.0)) ((r, c) => ((r._1 + (c / r._2)) * r._2 / (r._2 + 1), r._2 + 1))._1
  //  case Nil => NaN
  //}

  def last[A](list: List[A]): A = list.foldLeft(list.head)((_, c) => c)

  def penultimate[A](list: List[A]): A = list.foldLeft((list.head, list.tail.head))((r, c) => (r._2, c))._1

  def contains[A](list: List[A], item: A): Boolean = list.foldLeft(false) (_ || _ == item)

  def get[A](list: List[A], idx: Int): A =
    list.foldLeft(list.head, 0) ((r, c) => if (r._2 == idx) r else (c, r._2+1)) match {
      case (result, index) if (index == idx) => result
      case _ => throw new Exception("bad index")
  }

  def mimicToString[A](list: List[A]): String = list match {
    case head :: tail => tail.foldLeft("List (" + head) (_ + ", " + _)
    case Nil => ")"
  }

  def reverse[A](list: List[A]): List[A] = list.foldLeft(List[A]()) ((r, c) => c :: r)

  def unique[A](list: List[A]): List[A] = list.foldLeft(List[A]()) ((r, c) => if (r.contains(c)) r else c :: r).reverse

  def toSet[A](list: List[A]): Set[A] = list.foldLeft(Set[A]()) ((r, c) => r + c)

  def double[A](list: List[A]): List[A] = list.foldLeft(List[A]()) ((r, c) => c :: c :: r).reverse
}