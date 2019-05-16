package tv.codely.api_scala_http.module.video.domain

import scala.concurrent.duration._

object VideoDuration {
  def apply(seconds: BigDecimal): VideoDuration = VideoDuration(seconds.longValue().seconds)
}

case class VideoDuration(value: Duration) {
  val toSeconds = value.toSeconds
}
