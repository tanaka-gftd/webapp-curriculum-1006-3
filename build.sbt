scalaVersion := "2.12.10"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

val osName: SettingKey[String] = SettingKey[String]("osName")
osName := (System.getProperty("os.name") match {
    case name if name.startsWith("Linux") => "linux"
    case name if name.startsWith("Mac") => "mac"
    case name if name.startsWith("Windows") => "win"
    case _ => throw new Exception("Unknown platform!")
})

libraryDependencies += "org.openjfx" % "javafx-base" % "11-ea+25" classifier osName.value
libraryDependencies += "org.openjfx" % "javafx-controls" % "11-ea+25" classifier osName.value
libraryDependencies += "org.openjfx" % "javafx-fxml" % "11-ea+25" classifier osName.value
libraryDependencies += "org.openjfx" % "javafx-graphics" % "11-ea+25" classifier osName.value
libraryDependencies += "org.openjfx" % "javafx-web" % "11-ea+25" classifier osName.value

assembly / assemblyMergeStrategy := {
    case PathList("module-info.class") => MergeStrategy.first
    case x => (assembly / assemblyMergeStrategy).value(x)
}
