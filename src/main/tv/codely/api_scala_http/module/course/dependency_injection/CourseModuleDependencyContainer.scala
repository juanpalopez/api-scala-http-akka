package tv.codely.api_scala_http.module.course.dependency_injection

import tv.codely.api_scala_http.module.course.application.{CourseCreator, CoursesSearcher}
import tv.codely.api_scala_http.module.course.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {
  val repository      = new InMemoryCourseRepository
  val coursesSearcher = new CoursesSearcher(repository)
  val courseCreator   = new CourseCreator(repository)
}
