package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model._
import spray.json._
import tv.codely.api_scala_http.module.course.infrastructure.marshaller.CourseJsValueMarshaller
import tv.codely.api_scala_http.module.course.infrastructure.stub.CourseStub
import tv.codely.api_scala_http.module.user.infrastructure.marshaller.UserJsValueMarshaller
import tv.codely.api_scala_http.module.user.infrastructure.stub.UserStub
import tv.codely.api_scala_http.module.video.infrastructure.marshaller.VideoJsValueMarshaller
import tv.codely.api_scala_http.module.video.infrastructure.stub.VideoStub

import scala.concurrent.duration._

final class ApiScalaHttpTest extends AcceptanceSpec {

  "Scala API HTTP Test" should {

    "respond succesfully while requesting its status" in {
      get("/status") {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
    "return a list the system users when request GET /users" in {
      get("/users")  {
        val expectedUsers = Seq(
          UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
          UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe UserJsValueMarshaller.marshall(expectedUsers)
      }
    }
    "return all the system video when request GET /videos" in {
      get("/videos") {
        val expectedVideos = Seq(
          VideoStub(
            id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
            title = "🎥 Scala FTW vol. 1",
            duration = 1.minute,
            category = "Screencast"
          ),
          VideoStub(
            id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
            title = "🔝 Interview with Odersky",
            duration = 30.minutes,
            category = "Interview"
          )
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe VideoJsValueMarshaller.marshall(expectedVideos)
      }
    }
    "return all the system courses when request GET /courses" in {
      get("/courses") {
        val expectedCourses = Seq(
          CourseStub(
            id="e295ecdf-ba69-4672-a34f-400bfc3473df",
            title="Intro to Scala",
            VideoStub(
              id="2bccec03-c15d-46dd-9884-d0d8e554ed56",
              title="What is Functional Programming",
              duration = 30.minutes,
              category = "Screencast"
            )
          ),
          CourseStub(
            id="bf4e10d4-7a89-4e59-8bda-872ee8f61e78",
            title="SOLID Principles",
            VideoStub(
              id="43f19a9c-4bc4-42e8-bace-44c0707ed87f",
              title="Introduction to SOLID Principles",
              duration = 20.minutes,
              category = "Screencast"
            )
          )
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(expectedCourses)
      }
    }
  }

}
