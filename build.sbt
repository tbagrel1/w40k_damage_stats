ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .aggregate(
    core,
    cli,
    webapp
  )

lazy val core = (project in file("core"))
  .settings(
    name := "DamageStats - Core",
    idePackagePrefix := Some("com.tbagrel1.w40kds.core")
  )

lazy val cli = (project in file("cli"))
  .settings(
    name := "DamageStats - CLI",
    idePackagePrefix := Some("com.tbagrel1.w40kds.cli")
  )
  .dependsOn(core)

lazy val webapp = (project in file("webapp"))
  .settings(
    name := "DamageStats - Web app",
    idePackagePrefix := Some("com.tbagrel1.w40kds.webapp")
  )
  .dependsOn(core)
