import scalaz._
import Scalaz._

class Lenses{}

case class Startup(name: String, city: String, numOfEmployees: Int)
case class Engineer(name: String, startup: Startup, skills: List[String])

object Engineer {

  val startupNumOfEmployeesLens = Lens(
    get = (_: Startup).numOfEmployees
    set = (startup: Startup, numOfEmployees: Int) => startup.copy(numOfEmployees = 40)
  )

  val engineerStartupLens = Lens(
    get = (_: Engineer).startup
    set = (engineer: Engineer, startup: Startup) => engineer.copy(startup = startup)
  )

  val engineerStartupNumOfEmployeesLens = engineerStartupLens andThen startupNumOfEmployeesLens

  val agerrr = Engineer("agerrr", new List("scala", "java", "python"), Startup("Startup", "Redwood City", 40))

  val updatedStartupNumOfEmployees = engineerStartupNumOfEmployeesLens.set(agerrr, engineerStartupNumOfEmployeesLens.get(agerrr) + 1)
}