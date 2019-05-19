package tv.codely.api_scala_http.module.video

import tv.codely.api_scala_http.module.IntegrationTestCase
import tv.codely.api_scala_http.module.video.dependency_injection.VideoModuleDependencyContainer
import tv.codely.api_scala_http.module.video.repository.InMemoryVideoRepository

protected[video] trait VideoIntegrationTestCase extends IntegrationTestCase {
  private val container                             = new VideoModuleDependencyContainer
  protected val repository: InMemoryVideoRepository = container.repository
}
