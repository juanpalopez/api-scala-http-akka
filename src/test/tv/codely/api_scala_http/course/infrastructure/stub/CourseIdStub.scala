package tv.codely.api_scala_http.course.infrastructure.stub

import java.util.UUID

import tv.codely.api_scala_http.course.domain.CourseId
import tv.codely.api_scala_http.shared.infrastructure.UuidStub

object CourseIdStub {
  def apply(value: String): CourseId = CourseIdStub(UuidStub(value))

  def apply(value: UUID): CourseId = CourseId(value)

  def random: CourseId = CourseId(UuidStub.random)
}
