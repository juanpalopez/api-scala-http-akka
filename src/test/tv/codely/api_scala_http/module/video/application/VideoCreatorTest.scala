package tv.codely.api_scala_http.module.video.application

import tv.codely.api_scala_http.module.video.VideoUnitTestCase
import tv.codely.api_scala_http.module.video.domain.VideoStub

private class VideoCreatorTest extends VideoUnitTestCase{
  private val creator = new VideoCreator(repository)

  "Video creator" should{
    "Save a video" in {
      val video = VideoStub.random

      shouldSaveVideo(video)

      creator.create(video.id, video.title, video.duration, video.category) should be ()
    }
  }
}
