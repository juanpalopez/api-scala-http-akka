package tv.codely.api_scala_http.module.video.domain

trait VideoRepository {
  def all(): Seq[Video]

  def save(video: Video):Unit
}
