package tv.codely.api_scala_http.module.course.domain

import tv.codely.api_scala_http.module.shared.domain.{IntStub, StringStub}

object CourseTitleStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): CourseTitle = CourseTitle(value)

  def random: CourseTitle = CourseTitle(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
