package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model._
import spray.json._
import tv.codely.api_scala_http.module.course.domain.CourseStub
import tv.codely.api_scala_http.module.course.infrastructure.marshaller.CourseJsValueMarshaller
import tv.codely.api_scala_http.module.video.domain.VideoStub

import scala.concurrent.duration._

final class CourseSpec extends AcceptanceSpec {
  "save a course" in post(
    "/courses",
    """
      |{
      |  "id": "e295ecdf-ba69-4672-a34f-400bfc3473df",
      |  "title": "Intro to Scala",
      |  "videoId": "2bccec03-c15d-46dd-9884-d0d8e554ed56",
      |  "videoTitle": "What is Functional Programming",
      |  "duration_in_minutes": 30,
      |  "videoCategory": "Screencast"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }
  "return all the system courses when request GET /courses" in {
    get("/courses") {
      val expectedCourses = Seq(
        CourseStub(
          id = "e295ecdf-ba69-4672-a34f-400bfc3473df",
          title = "Intro to Scala",
          video = VideoStub(
            id = "2bccec03-c15d-46dd-9884-d0d8e554ed56",
            title = "What is Functional Programming",
            duration = 30.minutes,
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
