package tv.codely.api_scala_http.module.user.domain

trait UserRepository {
  def all(): Seq[User]
  def save(user: User): Unit
}
