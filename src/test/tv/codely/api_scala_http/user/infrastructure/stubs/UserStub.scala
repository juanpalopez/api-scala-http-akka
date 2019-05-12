package tv.codely.api_scala_http.user.infrastructure.stubs

import tv.codely.api_scala_http.user.domain.User

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UserNameStub.random.value
  ): User = User(id, name)

  def random: User = apply()
}
