package tv.codely.api_scala_http.entry_point.controller.user

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import tv.codely.api_scala_http.module.user.application.UserCreator
import tv.codely.api_scala_http.module.user.domain.{UserId, UserName}

final class UserPostController(creator: UserCreator) {
  def post(id:String, name:String): StandardRoute = {
    creator.create(UserId(id), UserName(name))
    complete(HttpResponse(NoContent))
  }
}
