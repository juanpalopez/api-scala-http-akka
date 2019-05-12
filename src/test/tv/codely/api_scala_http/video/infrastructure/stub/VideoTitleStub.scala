package tv.codely.api_scala_http.video.infrastructure.stub

import tv.codely.api_scala_http.shared.infrastructure.{IntStub, StringStub}
import tv.codely.api_scala_http.video.domain.VideoTitle

object VideoTitleStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): VideoTitle = VideoTitle(value)

  def random: VideoTitle = VideoTitle(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
