package tv.codely.api_scala_http.user.domain

import java.util.UUID

object UserId {
  def apply(value: String): UserId = UserId(UUID.fromString(value))
}

case class UserId(value: UUID) {
  override val toString: String = value.toString()
}
