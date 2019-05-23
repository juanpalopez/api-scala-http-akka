package tv.codely.api_scala_http.entry_point.controller.video

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.server.StandardRoute
import tv.codely.api_scala_http.module.video.application.VideoCreator
import tv.codely.api_scala_http.module.video.domain.{VideoCategory, VideoDuration, VideoId, VideoTitle}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes.NoContent
import tv.codely.api_scala_http.module.course.domain.CourseId

import scala.concurrent.duration.Duration

final class VideoPostController(creator: VideoCreator) {
  def post(id: String, title: String, duration: Duration, category: String, courseId: String): StandardRoute = {
    creator.create(VideoId(id), VideoTitle(title), VideoDuration(duration), VideoCategory(category), CourseId(courseId))

    complete(HttpResponse(NoContent))
  }
}
