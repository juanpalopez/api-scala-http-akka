package tv.codely.api_scala_http.module.user.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.user.application.UsersSearcher
import tv.codely.api_scala_http.module.user.infrastructure.repository.InMemoryUserRepository

final class UserModuleDependencyContainer {
  val repository = new InMemoryUserRepository
  val usersSearcher = new UsersSearcher(repository)
}
