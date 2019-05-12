package tv.codely.api_scala_http.course.domain

import java.util.UUID

object CourseId {
  def apply(value: String): CourseId = CourseId(UUID.fromString(value))
}
case class CourseId(value: UUID) {
  override val toString = value.toString
}
