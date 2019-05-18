package tv.codely.api_scala_http.module.user.infrastructure.repository

import tv.codely.api_scala_http.module.user.domain.{User, UserRepository}

final class InMemoryUserRepository extends UserRepository{
  private var users = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  def all(): Seq[User] = users

  def save(user: User):Unit = users = users :+ user
}
