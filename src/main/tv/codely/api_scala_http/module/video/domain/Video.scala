package tv.codely.api_scala_http.module.video.domain

import tv.codely.api_scala_http.module.course.domain.CourseId

import scala.concurrent.duration.Duration

object Video {
  def apply(id: String, title: String, duration: Duration, category: String, courseId: String): Video =
    Video(VideoId(id), VideoTitle(title), VideoDuration(duration), VideoCategory(category), CourseId(courseId))
}

case class Video(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory, courseId: CourseId)
