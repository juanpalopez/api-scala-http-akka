package tv.codely.api_scala_http.module.course.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.course.application.{CourseCreator, CoursesSearcher}
import tv.codely.api_scala_http.module.course.infrastructure.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {
  val repository      = new InMemoryCourseRepository
  val coursesSearcher = new CoursesSearcher(repository)
  val courseCreator   = new CourseCreator(repository)
}
