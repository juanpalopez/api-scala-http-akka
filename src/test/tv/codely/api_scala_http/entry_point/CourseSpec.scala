package tv.codely.api_scala_http.entry_point

import spray.json._
import akka.http.scaladsl.model._
import scala.concurrent.duration._
import tv.codely.api_scala_http.module.course.infrastructure
import tv.codely.api_scala_http.module.course.infrastructure.marshaller.CourseJsValueMarshaller
import tv.codely.api_scala_http.module.course.infrastructure.stub.CourseStub
import tv.codely.api_scala_http.module.video.infrastructure.stub
import tv.codely.api_scala_http.module.video.infrastructure.stub.VideoStub

final class CourseSpec extends  AcceptanceSpec {
  "return all the system courses when request GET /courses" in {
    get("/courses") {
      val expectedCourses = Seq(
        CourseStub(
          id="e295ecdf-ba69-4672-a34f-400bfc3473df",
          title="Intro to Scala",
          stub.VideoStub(
            id="2bccec03-c15d-46dd-9884-d0d8e554ed56",
            title="What is Functional Programming",
            duration = 30.minutes,
            category = "Screencast"
          )
        ),
        infrastructure.stub.CourseStub(
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
