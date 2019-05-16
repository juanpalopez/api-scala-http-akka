package tv.codely.api_scala_http.module.user.infrastructure.stubs

import java.util.UUID

import tv.codely.api_scala_http.shared.infrastructure.UuidStub
import tv.codely.api_scala_http.module.user.domain.UserId

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
