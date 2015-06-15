import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

sealed abstract class Tree
case class Node(left: Tree, right: Tree, v: Int) extends Tree
case object Leaf extends Tree

object ScalaCheckGenerator {

  // Example generator
  val myGen = for {
      n <- Gen.choose(10,20)
      m <- Gen.choose(2*n, 500)
    } yield (n,m)

  // The generator generates vowels using uniform distribution: 
  val vowel = Gen.oneOf('A', 'E', 'I', 'O', 'U', 'Y')

  // But we can also modifify the distribution using frequency:
  val note = Gen.frequency(
      (3, 'C'),
      (4, 'D'),
      (2, 'E'),
      (3, 'F'),
      (1, 'G'),
      (1, 'A'),
      (1, 'B')
    )

  // Example case class tree generator:
  val genLeaf = const(Leaf)

  val genNode = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(left, right, v)

  def genTree: Gen[Tree] = oneOf(genLeaf, genNode)

  // Conditional generators:
  val smallOddInteger = Gen.choose(0,200) suchThat (_ % 2 != 0)

}

