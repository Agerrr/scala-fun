import scalaz._
import Scalaz._

class Lenses{}

case class Startup(name: String, city: String, numOfEmployees: Int)
case class Engineer(name: String, startup: Startup, skills: List[String])

object Engineer {

  val startupNumOfEmployeesLens = Lens.lensu[Startup, Int](
    (startup: Startup, numOfEmployees: Int) => startup.copy(numOfEmployees = 40),
    (_: Startup).numOfEmployees
  )

  val engineerStartupLens = Lens.lensu[Engineer, Startup](
    (engineer: Engineer, startup: Startup) => engineer.copy(startup = startup),
    (_: Engineer).startup
  )

  val engineerStartupNumOfEmployeesLens = engineerStartupLens andThen startupNumOfEmployeesLens

  val agerrr = Engineer("agerrr", Startup("Startup", "Redwood City", 40), List("scala", "java", "python"))

  val updatedStartupNumOfEmployees = engineerStartupNumOfEmployeesLens.set(agerrr, engineerStartupNumOfEmployeesLens.get(agerrr) + 1)
}
