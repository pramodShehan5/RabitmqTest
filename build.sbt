name := "RabbitmqTest"

version := "0.1"

scalaVersion := "2.12.3"



libraryDependencies <<= scalaVersion { scala_version =>
  Seq(
    "com.rabbitmq"         % "amqp-client"          % "3.5.2"
  )
}