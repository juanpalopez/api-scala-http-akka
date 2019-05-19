package tv.codely.api_scala_http.module.user.application

import tv.codely.api_scala_http.module.user.UserUnitTestCase
import tv.codely.api_scala_http.module.user.domain.UserStub


final class UsersSearcherTest extends UserUnitTestCase {
  private val searcher = new UsersSearcher(repository)

  "Users Searcher" should {
    "search all existing users" in {
      val existingUser        = UserStub.random
      val anotherExistingUser = UserStub.random
      val existingUsers       = Seq(existingUser, anotherExistingUser)

      shouldSearchAllUsers(existingUsers)

      searcher.all() should be (existingUsers)
    }
  }
}
