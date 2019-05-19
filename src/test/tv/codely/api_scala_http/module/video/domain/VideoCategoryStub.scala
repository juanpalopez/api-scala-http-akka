package tv.codely.api_scala_http.module.video.domain

import tv.codely.api_scala_http.module.shared.domain.IntStub

object VideoCategoryStub {
  private val categories = Seq("Screencast", "Interview")

  def apply(value: String): VideoCategory = VideoCategory(value)

  def random: VideoCategory = VideoCategory(categories(IntStub.randomBetween(min = 0, max = categories.size - 1)))
}
