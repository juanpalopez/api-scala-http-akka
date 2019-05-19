package tv.codely.api_scala_http.module.video.application

import tv.codely.api_scala_http.module.video.VideoUnitTestCase
import tv.codely.api_scala_http.module.video.domain.{Video, VideoStub}

private class VideoSearchTest extends VideoUnitTestCase {
  private val searcher = new VideosSearcher(repository)

  "Video searcher" should {
    "search all videos" in {
      val existingVideo              = VideoStub.random
      val anotherExistingVideo       = VideoStub.random
      val existingVideos: Seq[Video] = Seq(existingVideo, anotherExistingVideo)

      repositoryShouldSearchAllVideos(existingVideos)
      searcher.all() shouldBe existingVideos
    }
  }
}
