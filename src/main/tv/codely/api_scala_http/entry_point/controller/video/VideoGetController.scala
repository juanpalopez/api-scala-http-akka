package tv.codely.api_scala_http.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.api_scala_http.module.video.application.VideosSearcher
import tv.codely.api_scala_http.module.video.infrastructure.marshaller.VideoMarshaller._


final class VideoGetController (searcher: VideosSearcher) extends SprayJsonSupport with DefaultJsonProtocol{
  def get(): StandardRoute = complete(searcher.searchAll())
}
