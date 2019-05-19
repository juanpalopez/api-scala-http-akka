package tv.codely.api_scala_http.module.user

import tv.codely.api_scala_http.module.IntegrationTestCase
import tv.codely.api_scala_http.module.user.dependency_injection.UserModuleDependencyContainer

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container    = new UserModuleDependencyContainer
  protected val repository = container.repository
}
