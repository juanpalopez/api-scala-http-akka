package tv.codely.api_scala_http.module.video.domain

import scala.concurrent.duration.Duration

object VideoStub {
  def apply(id: String = VideoIdStub.random.toString,
            title: String = VideoTitleStub.random.toString,
            duration: Duration = VideoDurationStub.random.value,
            category: String = VideoCategoryStub.random.toString): Video = Video(id, title, duration, category)

  def random: Video = apply()
}
