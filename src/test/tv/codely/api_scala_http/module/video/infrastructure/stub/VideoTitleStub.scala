package tv.codely.api_scala_http.module.video.infrastructure.stub

import tv.codely.api_scala_http.module.shared.stub.{IntStub, StringStub}
import tv.codely.api_scala_http.module.video.domain.VideoTitle

object VideoTitleStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): VideoTitle = VideoTitle(value)

  def random: VideoTitle = VideoTitle(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
