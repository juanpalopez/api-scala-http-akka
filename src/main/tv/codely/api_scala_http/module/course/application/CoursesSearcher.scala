package tv.codely.api_scala_http.module.course.application

import tv.codely.api_scala_http.module.course.domain.{Course, CourseRepository}

final class CoursesSearcher(repository: CourseRepository) {

  def all(): Seq[Course] = repository.all()
}
