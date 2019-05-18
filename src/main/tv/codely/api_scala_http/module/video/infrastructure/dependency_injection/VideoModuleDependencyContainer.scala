package tv.codely.api_scala_http.module.video.infrastructure.dependency_injection

import tv.codely.api_scala_http.module.video.application.VideosSearcher
import tv.codely.api_scala_http.module.video.infrastructure.repository.InMemoryVideoRepository

final class VideoModuleDependencyContainer {
  private val repository = new InMemoryVideoRepository
  val videosSearcher = new VideosSearcher(repository)
}
