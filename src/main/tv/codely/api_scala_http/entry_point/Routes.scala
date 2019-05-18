package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


final class Routes(container: EntryPointDependencyContainer)  {

  val all: Route =
    get {
      path("status")(container.statusGetController.get()) ~
      path("users")(container.userGetController.get()) ~
      path("videos")(container.videoGetController.get()) ~
      path("courses")(container.courseGetController.get())
    }
}
