import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "webshop"
    val appVersion      = "1.0"

    val appDependencies = Seq(
        "com.typesafe" % "play-plugins-guice" % "2.0.1",
        "mysql" % "mysql-connector-java" % "5.1.19",
        "org.functionaljava" % "functionaljava" % "3.0"
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
    )

}
