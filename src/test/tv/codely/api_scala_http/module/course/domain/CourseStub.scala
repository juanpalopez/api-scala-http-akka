package tv.codely.api_scala_http.module.course.domain

import tv.codely.api_scala_http.module.video.domain.{Video, VideoStub}

object CourseStub {
  def apply(id: String = CourseIdStub.random.toString,
            title: String = CourseTitleStub.random.toString,
            video: Video = VideoStub.random): Course = Course(id, title, video)

  def random: Course = apply()
}
