package tv.codely.api_scala_http.module.video.domain

import tv.codely.api_scala_http.module.shared.domain.DurationStub

import scala.concurrent.duration.Duration

object VideoDurationStub {
  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
