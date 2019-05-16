package tv.codely.api_scala_http.module.video.infrastructure.stub

import tv.codely.api_scala_http.shared.infrastructure.IntStub
import tv.codely.api_scala_http.module.video.domain.VideoCategory

object VideoCategoryStub {
  private val categories = Seq("Screencast", "Interviews")

  def apply(value: String): VideoCategory = VideoCategory(value)

  def random: VideoCategory = VideoCategory(categories(IntStub.randomBetween(min = 0, max = categories.size - 1)))
}
