package tv.codely.api_scala_http.module.video.application

import tv.codely.api_scala_http.module.video.domain.{Video, VideoRepository}

final class VideosSearcher(repository: VideoRepository) {
  def all(): Seq[Video] = repository.all()
}
