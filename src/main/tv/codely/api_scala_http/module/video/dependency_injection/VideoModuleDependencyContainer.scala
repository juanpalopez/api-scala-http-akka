package tv.codely.api_scala_http.module.video.dependency_injection

import tv.codely.api_scala_http.module.video.application.{VideoCreator, VideosSearcher}
import tv.codely.api_scala_http.module.video.repository.InMemoryVideoRepository

final class VideoModuleDependencyContainer {
  val repository = new InMemoryVideoRepository

  val videosSearcher     = new VideosSearcher(repository)
  val videoCreator       = new VideoCreator(repository)
}
