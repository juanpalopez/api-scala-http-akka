package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model._
import spray.json._
import tv.codely.api_scala_http.module.course.domain.CourseStub
import tv.codely.api_scala_http.module.course.infrastructure.marshaller.CourseJsValueMarshaller

final class CourseSpec extends AcceptanceSpec {
  "save a course" in post(
    "/courses",
    """
      |{
      |  "id": "e295ecdf-ba69-4672-a34f-400bfc3473df",
      |  "title": "Intro to Scala",
      |  "description": "This is an introduction to Scala Language"
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
          description = "This is an introduction to Scala Language"
        )
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(expectedCourses)
    }
  }
}
