package tv.codely.api_scala_http.entry_point

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import tv.codely.api_scala_http.module.course.dependency_injection.CourseModuleDependencyContainer
import tv.codely.api_scala_http.module.user.dependency_injection.UserModuleDependencyContainer
import tv.codely.api_scala_http.module.video.dependency_injection.VideoModuleDependencyContainer

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object ApiScalaHttp {
  def main(args: Array[String]): Unit = {
    val appConfig    = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host            = serverConfig.getString("http-server.host")
    val port            = serverConfig.getInt("http-server.port")

    implicit val system: ActorSystem                        = ActorSystem(actorSystemName)
    implicit val materializer: ActorMaterializer            = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val container = new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
      new VideoModuleDependencyContainer,
      new CourseModuleDependencyContainer
    )

    val routes = new Routes(container)

    val bindingFuture = Http().bindAndHandle(routes.all, host, port)

    println(s"Server online http://$host:$port/\nPress RETURN to stop...")
    StdIn.readLine()

    bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
  }
}
