package tv.codely.api_scala_http.course.infrastructure.stub

import tv.codely.api_scala_http.course.domain.Course
import tv.codely.api_scala_http.video.domain.Video

object CourseStub {
  def apply(id: String = CourseIdStub.random.toString,
            title: String = CourseTitleStub.random.toString,
            video: Video): Course = Course(id, title, video)
}
