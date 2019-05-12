package tv.codely.api_scala_http.user.infrastructure.stubs

import tv.codely.api_scala_http.shared.infrastructure.{IntStub, StringStub}
import tv.codely.api_scala_http.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
