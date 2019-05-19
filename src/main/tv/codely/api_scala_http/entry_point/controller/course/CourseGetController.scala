package tv.codely.api_scala_http.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.module.course.application.CoursesSearcher
import tv.codely.api_scala_http.module.course.infrastructure.CourseMarshaller._

final class CourseGetController(searcher: CoursesSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
