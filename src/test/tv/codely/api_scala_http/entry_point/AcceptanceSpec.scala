package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, MediaTypes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import tv.codely.api_scala_http.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.api_scala_http.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.api_scala_http.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

protected[entry_point] abstract class AcceptanceSpec
    extends WordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {
  private val routes = new Routes(
    new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
      new VideoModuleDependencyContainer,
      new CourseModuleDependencyContainer
    )
  )

  def get[T](path: String)(body: => T): T = Get(path) ~> routes.all ~> check(body)

  def post[T](path: String, request: String)(body: => T): T =
    HttpRequest(
      method = HttpMethods.POST,
      uri = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(
      body
    )
}
