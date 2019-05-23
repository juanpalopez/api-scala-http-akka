package tv.codely.api_scala_http.module.video.application

import tv.codely.api_scala_http.module.course.domain.CourseId
import tv.codely.api_scala_http.module.video.domain._

final class VideoCreator(repository: VideoRepository) {
  def create(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory, courseId:CourseId): Unit = {
    val video = Video(id, title, duration, category, courseId)

    repository.save(video)
  }
}
