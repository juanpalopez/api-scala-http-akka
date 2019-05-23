package tv.codely.api_scala_http.module.course.domain

import tv.codely.api_scala_http.module.shared.domain.{IntStub, StringStub}

object CourseDescriptionStub {
  private val minimunChars = 10
  private val maximunChars = 150

  def apply(value: String): CourseDescription = CourseDescription(value)

  def random: CourseDescription = CourseDescription(
    StringStub.random(numChars = IntStub.randomBetween(minimunChars, maximunChars))
  )

}
