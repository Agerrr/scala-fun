class DeathDiamond {

  trait Base {
     def op: String
  }

  trait Foo extends Base {
     override def op = "foo"
  }

  trait Bar extends Base {
     override def op = "bar"
  }

  class A extends Foo with Bar
  class B extends Bar with Foo

  (new A).op
  // res0: String = bar

  (new B).op
  // res1: String = foo
}