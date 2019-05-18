package tv.codely.api_scala_http.module.user.infrastructure.stub

import tv.codely.api_scala_http.module.shared.stub.{IntStub, StringStub}
import tv.codely.api_scala_http.shared.infrastructure.StringStub
import tv.codely.api_scala_http.module.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
