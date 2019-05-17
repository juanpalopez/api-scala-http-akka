package tv.codely.api_scala_http.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.module.video.domain.Video
import tv.codely.api_scala_http.module.video.infrastructure.VideoMarshaller._

import scala.concurrent.duration._

object VideoGetController extends SprayJsonSupport with DefaultJsonProtocol{
  private val systemVideos = Seq(
    Video(
      id = "3dfb19ee-260b-420a-b08c-ed58a7a07aee",
      title = "🎥 Scala FTW vol. 1",
      duration = 1.minute,
      category = "Screencast"
    ),
    Video(
      id = "7341b1fc-3d80-4f6a-bcde-4fef86b01f97",
      title = "🔝 Interview with Odersky",
      duration = 30.minutes,
      category = "Interview"
    )
  )
  def apply(): StandardRoute = complete(systemVideos)
}
