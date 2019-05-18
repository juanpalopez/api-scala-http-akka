package tv.codely.api_scala_http.entry_point.controller.course

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import tv.codely.api_scala_http.module.course.application.CourseCreator
import tv.codely.api_scala_http.module.course.domain.{CourseId, CourseTitle}
import tv.codely.api_scala_http.module.video.domain._

import scala.concurrent.duration.Duration

final class CoursePostController(creator:CourseCreator){
  def post(id:String, title:String, videoId:String, videoTitle:String, videoDuration:Duration, videoCategory:String):StandardRoute ={
    creator.create(CourseId(id), CourseTitle(title),Video(VideoId(videoId),
                                                          VideoTitle(videoTitle),
                                                          VideoDuration(videoDuration),
                                                          VideoCategory(videoCategory)
                                                          )
    )
    complete(HttpResponse(NoContent))
  }
}
