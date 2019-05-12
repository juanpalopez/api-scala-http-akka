package tv.codely.api_scala_http.course.domain

import tv.codely.api_scala_http.video.domain.Video

object Course {
  def apply(id: String, title: String, video: Video): Course =
    Course(CourseId(id), CourseTitle(title), video)
}

case class Course(id: CourseId, title: CourseTitle, video: Video)
