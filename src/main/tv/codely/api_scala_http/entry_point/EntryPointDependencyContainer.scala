package tv.codely.api_scala_http.entry_point

import tv.codely.api_scala_http.entry_point.controller.user.UserGetController
import tv.codely.api_scala_http.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(userDependencies: UserModuleDependencyContainer){
  val userGetController = new UserGetController(userDependencies.usersSearcher)
}
