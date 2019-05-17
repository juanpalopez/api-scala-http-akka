package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import tv.codely.api_scala_http.entry_point.controller.course.CourseGetController
import tv.codely.api_scala_http.entry_point.controller.status.StatusGetController
import tv.codely.api_scala_http.entry_point.controller.user.UserGetController
import tv.codely.api_scala_http.entry_point.controller.video.VideoGetController


object Routes  {

  val all: Route =
    get {
      path("status")(StatusGetController()) ~
      path("users")(UserGetController()) ~
      path("videos")(VideoGetController()) ~
      path("courses")(CourseGetController())
    }
}
