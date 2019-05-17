package tv.codely.api_scala_http.entry_point.controller.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.module.user.application.UsersSearcher
import tv.codely.api_scala_http.module.user.infrastructure.UserMarshaller._

final class UserGetController(searcher: UsersSearcher) extends SprayJsonSupport with DefaultJsonProtocol{

  def get(): StandardRoute = {
    complete(searcher.searchAll())
  }
}
