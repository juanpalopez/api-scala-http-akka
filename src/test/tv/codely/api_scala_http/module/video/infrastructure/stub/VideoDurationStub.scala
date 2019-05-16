package tv.codely.api_scala_http.module.video.infrastructure.stub

import tv.codely.api_scala_http.shared.infrastructure.DurationStub
import tv.codely.api_scala_http.module.video.domain.VideoDuration

import scala.concurrent.duration.Duration

object VideoDurationStub {
  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
