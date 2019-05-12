package tv.codely.api_scala_http.video.domain

import java.util.UUID

object VideoId {
  def apply(value: String): VideoId = VideoId(UUID.fromString(value))
}

case class VideoId(value: UUID) {
  override val toString = value.toString
}
