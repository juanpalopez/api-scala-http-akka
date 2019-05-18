package tv.codely.api_scala_http.module.user.application

import tv.codely.api_scala_http.module.user.domain.{User, UserRepository}

final class UsersSearcher (repository: UserRepository) {
  def searchAll(): Seq[User]= repository.all()
}
