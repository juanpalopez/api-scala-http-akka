package tv.codely.api_scala_http

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.course.domain.Course
import tv.codely.api_scala_http.user.domain.User
import tv.codely.api_scala_http.user.infrastructure.UserMarshaller._
import tv.codely.api_scala_http.video.domain.Video
import tv.codely.api_scala_http.video.infrastructure.VideoMarshaller._
import tv.codely.api_scala_http.course.infrastructure.CourseMarshaller._

import scala.concurrent.duration._

object Routes extends SprayJsonSupport with DefaultJsonProtocol {
  private val systemUsers = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  private val systemVideos = Seq(
    Video(
      id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
      title = "🎥 Scala FTW vol. 1",
      duration = 1.minute,
      category = "Screencast"
    ),
    Video(
      id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
      title = "🔝 Interview with Odersky",
      duration = 30.minutes,
      category = "Interview"
    )
  )

  private val systemCourses = Seq(
    Course(
      id="e295ecdf-ba69-4672-a34f-400bfc3473df",
      title="Intro to Scala",
      Video(
        id="2bccec03-c15d-46dd-9884-d0d8e554ed56",
        title="What is Functional Programming",
        duration = 30.minutes,
        category = "Screencast"
      )
    ),
    Course(
      id="bf4e10d4-7a89-4e59-8bda-872ee8f61e78",
      title="SOLID Principles",
      Video(
        id="43f19a9c-4bc4-42e8-bace-44c0707ed87f",
        title="Introduction to SOLID Principles",
        duration = 20.minutes,
        category = "Screencast"
      )
    )
  )

  val all: Route =
    get {
      path("status") {
        complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
      } ~
        path("ping") {
          complete(HttpEntity(ContentTypes.`application/json`, """{"data":"pong"}"""))
        } ~
        path("cool-trainers") {
          complete(HttpEntity(ContentTypes.`application/json`, """[{"name":"Javi"},{"name":"Rafa"}]"""))
        } ~
        path("users") {
          complete(systemUsers)
        } ~
        path("videos") {
          complete(systemVideos)
        } ~
        path("courses") {
          complete(systemCourses)
        }
    }
}
