package tv.codely.api_scala_http.module.video.application

import tv.codely.api_scala_http.module.video.domain._

final class VideoCreator(repository: VideoRepository) {
  def create(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory): Unit = {
    val video = Video(id, title, duration, category)

    repository.save(video)
  }
}
