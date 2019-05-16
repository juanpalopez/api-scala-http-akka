package tv.codely.api_scala_http.module.course.infrastructure.stub

import tv.codely.api_scala_http.module.course.domain.CourseTitle
import tv.codely.api_scala_http.shared.infrastructure.{IntStub, StringStub}

object CourseTitleStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): CourseTitle = CourseTitle(value)

  def random: CourseTitle  = CourseTitle(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
