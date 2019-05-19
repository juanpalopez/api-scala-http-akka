package tv.codely.api_scala_http.module.video.repository

import tv.codely.api_scala_http.module.video.domain.{Video, VideoRepository}

final class InMemoryVideoRepository extends VideoRepository {
  private var videos: Seq[Video] = Seq[Video]()

  def all(): Seq[Video] = videos

  def save(video: Video): Unit = videos = videos :+ video
}
