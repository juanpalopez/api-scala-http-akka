package tv.codely.api_scala_http.module.user.application

import tv.codely.api_scala_http.module.user.domain.User

final class UsersSearcher {
  private val users = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  def searchAll(): Seq[User]= users
}
