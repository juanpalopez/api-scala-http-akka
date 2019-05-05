package tv.codely.api_scala_http

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.server.Directives._

final class ApiScalaHttpTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  private val routesWithDefinedResponses =
    get {
      path("status") {
        complete(HttpEntity(ContentTypes.`application/json`,"""{"status":"ok"}"""))
      }
    } ~ {
      path("cool-trainers") {
        complete(HttpEntity(ContentTypes.`application/json`,"""[{"name":"Javi"},{"name":"Rafa"}]"""))
      }
    }

  "ApiTest" should {
    /**
      * This is a really dummy test because with it we're testing nothing but Akka HTTP routing system.
      * As you can see in the routesWithDefinedResponses defined above, we've already provided an implementation.
      *
      * However, this is useful to start digging a little in how Akka HTTP testkit works and so on.
      * More information: https://doc.akka.io/docs/akka-http/current/scala/http/routing-dsl/testkit.html
      */
    "respond succesfully while requesting its status" in {
      Get("/status") ~> routesWithDefinedResponses ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
    "return a list of cool trainers for request GET /cool-traienrs" in {
      Get("/cool-trainers") ~> routesWithDefinedResponses ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """[{"name":"Javi"},{"name":"Rafa"}]"""
      }
    }
  }

}
