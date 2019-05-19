package tv.codely.api_scala_http.module.video
import tv.codely.api_scala_http.module.UnitTestCase
import tv.codely.api_scala_http.module.video.domain.{Video, VideoRepository}

protected[video] trait VideoUnitTestCase extends UnitTestCase {
  protected val repository: VideoRepository = mock[VideoRepository]

  protected def shouldSearchAllVideos(videos: Seq[Video]): Unit =
    (repository.all _)
    .expects()
    .returning(videos)

  protected def shouldSaveVideo(video: Video): Unit =
    (repository.save _)
    .expects(video)
    .returning()
}
