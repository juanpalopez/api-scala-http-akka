package tv.codely.api_scala_http.module.user.application

import tv.codely.api_scala_http.module.user.UserUnitTestCase
import tv.codely.api_scala_http.module.user.domain.UserStub

final class UserCreatorTest extends UserUnitTestCase{
  protected val creator = new UserCreator(repository)

  "User Creator" should {
    "save a user" in {
      val user = UserStub.random

      shouldSaveUser(user)

      creator.create(user.id, user.name) should be()
    }
  }
}
