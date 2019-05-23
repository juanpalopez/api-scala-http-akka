package tv.codely.api_scala_http.module.course.application

import tv.codely.api_scala_http.module.course.domain
import tv.codely.api_scala_http.module.course.domain.{CourseDescription, CourseId, CourseRepository, CourseTitle}

final class CourseCreator(repository: CourseRepository) {
  def create(id: CourseId, title: CourseTitle, description: CourseDescription): Unit = {
    val course = domain.Course(id, title, description)
    repository.save(course)
  }
}
