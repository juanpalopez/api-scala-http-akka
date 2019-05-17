package tv.codely.api_scala_http.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.module.course
import tv.codely.api_scala_http.module.course.infrastructure.CourseMarshaller._
import tv.codely.api_scala_http.module.video.domain.Video

import scala.concurrent.duration._

object CourseGetController extends SprayJsonSupport with DefaultJsonProtocol{
  private val systemCourses = Seq(
    course.domain.Course(
      id = "e295ecdf-ba69-4672-a34f-400bfc3473df",
      title = "Intro to Scala",
      Video(
        id = "2bccec03-c15d-46dd-9884-d0d8e554ed56",
        title = "What is Functional Programming",
        duration = 30.minutes,
        category = "Screencast"
      )
    ),
    course.domain.Course(
      id = "bf4e10d4-7a89-4e59-8bda-872ee8f61e78",
      title = "SOLID Principles",
      Video(
        id = "43f19a9c-4bc4-42e8-bace-44c0707ed87f",
        title = "Introduction to SOLID Principles",
        duration = 20.minutes,
        category = "Screencast"
      )
    )
  )

  def apply(): StandardRoute = complete(systemCourses)
}
