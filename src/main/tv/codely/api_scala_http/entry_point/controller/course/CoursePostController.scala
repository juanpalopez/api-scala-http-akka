package tv.codely.api_scala_http.entry_point.controller.course

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import tv.codely.api_scala_http.module.course.application.CourseCreator
import tv.codely.api_scala_http.module.course.domain.{CourseDescription, CourseId, CourseTitle}

final class CoursePostController(creator: CourseCreator) {
  def post(id: String, title: String, description: String): StandardRoute = {
    creator.create(CourseId(id), CourseTitle(title), CourseDescription(description))
    complete(HttpResponse(NoContent))
  }
}
