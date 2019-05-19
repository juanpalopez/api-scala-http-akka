package tv.codely.api_scala_http.module.video.domain

import java.util.UUID

import tv.codely.api_scala_http.module.shared.domain.UuidStub

object VideoIdStub {
  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value: UUID): VideoId = VideoId(value)

  def random: VideoId = VideoId(UuidStub.random)
}
