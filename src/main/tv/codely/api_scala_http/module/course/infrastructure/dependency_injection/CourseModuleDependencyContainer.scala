package tv.codely.api_scala_http.module.course.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.course.application.CoursesSearcher

final class CourseModuleDependencyContainer {
  val coursesSearcher = new CoursesSearcher
}
