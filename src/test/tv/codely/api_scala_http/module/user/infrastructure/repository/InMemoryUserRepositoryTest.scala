package tv.codely.api_scala_http.module.user.infrastructure.repository

import tv.codely.api_scala_http.module.user.UserIntegrationTestCase
import tv.codely.api_scala_http.module.user.domain.UserStub

final class InMemoryUserRepositoryTest extends UserIntegrationTestCase {
  "In memory user video repository" should {
    "search all existing users" in {
      val user          = UserStub.random
      val anotherUser   = UserStub.random
      val existingUsers = Seq(user, anotherUser)

      repository.save(user)
      repository.save(anotherUser)
      repository.all() should be(existingUsers)
    }
  }
}
