package tv.codely.api_scala_http.video.domain

import scala.concurrent.duration.Duration

object Video {
  def apply(id: String, title: String, duration: Duration, category: String): Video =
    Video(VideoId(id),
          VideoTitle(title),
          VideoDuration(duration),
          VideoCategory(category)
    )
}

case class Video(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory)
