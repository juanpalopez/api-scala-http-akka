package tv.codely.api_scala_http.module.user.application

import tv.codely.api_scala_http.module.user.domain.{User, UserId, UserName, UserRepository}

final class UserCreator(repository: UserRepository) {
  def create(id: UserId, name: UserName): Unit = {
    val user = User(id, name)
    repository.save(user)
  }
}
