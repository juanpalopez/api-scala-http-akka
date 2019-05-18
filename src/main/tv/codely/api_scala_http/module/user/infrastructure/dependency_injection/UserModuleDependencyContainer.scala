package tv.codely.api_scala_http.module.user.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.user.application.{UserCreator, UsersSearcher}
import tv.codely.api_scala_http.module.user.infrastructure.repository.InMemoryUserRepository

final class UserModuleDependencyContainer {
  val repository    = new InMemoryUserRepository
  val usersSearcher = new UsersSearcher(repository)
  val userCreator = new UserCreator(repository)
}
