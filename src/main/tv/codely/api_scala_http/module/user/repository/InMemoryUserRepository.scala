package tv.codely.api_scala_http.module.user.repository

import tv.codely.api_scala_http.module.user.domain.{User, UserRepository}

final class InMemoryUserRepository extends UserRepository {
  private var users: Seq[User] = Seq[User]()

  def all(): Seq[User] = users

  def save(user: User): Unit = users = users :+ user
}
