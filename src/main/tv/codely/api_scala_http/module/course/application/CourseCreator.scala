package tv.codely.api_scala_http.module.course.application

import tv.codely.api_scala_http.module.course.domain
import tv.codely.api_scala_http.module.course.domain.{CourseId, CourseRepository, CourseTitle}
import tv.codely.api_scala_http.module.video.domain.Video

final class CourseCreator(repository:CourseRepository) {
  def create(id:CourseId, title:CourseTitle, video: Video): Unit = {
    val course = domain.Course(id, title, video)
    repository.save(course)
  }
}
