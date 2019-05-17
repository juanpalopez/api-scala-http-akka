package tv.codely.api_scala_http.module.user.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.user.application.UsersSearcher

final class UserModuleDependencyContainer {
  val usersSearcher = new UsersSearcher
}
