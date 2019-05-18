package tv.codely.api_scala_http.module.shared.stub

import java.util.UUID

object UuidStub {
  def apply(value: String): UUID = UUID.fromString(value)

  def random: UUID = UUID.randomUUID()
}
