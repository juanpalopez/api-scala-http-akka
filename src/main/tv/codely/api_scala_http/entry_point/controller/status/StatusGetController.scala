package tv.codely.api_scala_http.entry_point.controller.status

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute

final class StatusGetController {
  def get(): StandardRoute = complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
}
