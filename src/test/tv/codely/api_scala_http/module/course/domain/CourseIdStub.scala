package tv.codely.api_scala_http.module.course.domain

import java.util.UUID

import tv.codely.api_scala_http.module.shared.domain.UuidStub

object CourseIdStub {
  def apply(value: String): CourseId = CourseIdStub(UuidStub(value))

  def apply(value: UUID): CourseId = CourseId(value)

  def random: CourseId = CourseId(UuidStub.random)
}
