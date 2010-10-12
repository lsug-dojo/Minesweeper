import sbt._

class DojoProjects(info: ProjectInfo) extends ParentProject(info) {

  lazy val minesweeper = project("minesweeper-dojo", "Minesweeper Dojo", new Minesweeper(_))
  
  class Minesweeper(info: ProjectInfo) extends DefaultProject(info) {

    // Dependencies
    val junit = "junit" % "junit" % "4.8.1"
    val scalatest = "org.scalatest" % "scalatest" % "1.2"
  }
}
