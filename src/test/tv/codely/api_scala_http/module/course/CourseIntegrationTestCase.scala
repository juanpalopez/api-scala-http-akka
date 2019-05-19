package tv.codely.api_scala_http.module.course

import tv.codely.api_scala_http.module.IntegrationTestCase
import tv.codely.api_scala_http.module.course.dependency_injection.CourseModuleDependencyContainer

protected[course] trait CourseIntegrationTestCase extends IntegrationTestCase {
  private val container = new CourseModuleDependencyContainer
  protected val repository = container.repository
}
