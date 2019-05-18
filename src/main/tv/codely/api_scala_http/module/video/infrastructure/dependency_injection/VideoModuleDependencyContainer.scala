package tv.codely.api_scala_http.module.video.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.video.application.VideosSearcher

final class VideoModuleDependencyContainer {
  val videosSearcher = new VideosSearcher
}
