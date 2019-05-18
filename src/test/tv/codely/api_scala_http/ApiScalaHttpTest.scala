package tv.codely.api_scala_http

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import spray.json._
import tv.codely.api_scala_http.module.course.infrastructure.stub.CourseStub
import tv.codely.api_scala_http.entry_point.{EntryPointDependencyContainer, Routes}
import tv.codely.api_scala_http.module.course.infrastructure.CourseMarshaller
import tv.codely.api_scala_http.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.api_scala_http.module.user.infrastructure.UserMarshaller
import tv.codely.api_scala_http.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.api_scala_http.module.user.infrastructure.stub.UserStub
import tv.codely.api_scala_http.module.video.infrastructure.VideoMarshaller
import tv.codely.api_scala_http.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer
import tv.codely.api_scala_http.module.video.infrastructure.stub.VideoStub

import scala.concurrent.duration._

final class ApiScalaHttpTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  private val routes = new Routes(
    new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
      new VideoModuleDependencyContainer,
      new CourseModuleDependencyContainer)
  )

  "Scala API HTTP Test" should {

    /**
      * This is a really dummy test because with it we're testing nothing but Akka HTTP routing system.
      * As you can see in the routesWithDefinedResponses defined above, we've already provided an implementation.
      *
      * However, this is useful to start digging a little in how Akka HTTP testkit works and so on.
      * More information: https://doc.akka.io/docs/akka-http/current/scala/http/routing-dsl/testkit.html
      */
    "respond succesfully while requesting its status" in {
      Get("/status") ~> routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
//    "return a list of cool trainers for request GET /cool-trainers" in {
//      Get("/cool-trainers") ~> Routes.all ~> check {
//        status shouldBe StatusCodes.OK
//        contentType shouldBe ContentTypes.`application/json`
//        entityAs[String] shouldBe """[{"name":"Javi"},{"name":"Rafa"}]"""
//      }
//    }
    "return a list the system users when request GET /users" in {
      Get("/users") ~> routes.all ~> check {
        val expectedUsers = Seq(
          UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
          UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
      }
    }
    "return all the system video when request GET /videos" in {
      Get("/videos") ~> routes.all ~> check {
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
        entityAs[String].parseJson shouldBe VideoMarshaller.marshall(expectedVideos)
      }
    }
    "return all the system courses when request GET /courses" in {
      Get("/courses") ~> routes.all ~> check {
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
        entityAs[String].parseJson shouldBe CourseMarshaller.marshall(expectedCourses)
      }
    }
  }

}
