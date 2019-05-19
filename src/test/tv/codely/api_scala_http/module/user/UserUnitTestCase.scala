package tv.codely.api_scala_http.module.user

import tv.codely.api_scala_http.module.UnitTestCase
import tv.codely.api_scala_http.module.user.domain.{User, UserRepository}

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def repositoryShouldSaveUser(user: User): Unit =
    (repository.save _)
    .expects(user)
    .returning()

  protected def repositoryShouldSearchAllUsers(users: Seq[User]): Unit =
    (repository.all _)
      .expects()
      .returning(users)
}
