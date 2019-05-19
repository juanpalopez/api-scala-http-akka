package tv.codely.api_scala_http.module.course.application

import tv.codely.api_scala_http.module.course.CourseUnitTestCase
import tv.codely.api_scala_http.module.course.domain.CourseStub

final class CourseCreatorTest extends CourseUnitTestCase {
  private val creator = new CourseCreator(repository)

  "Course Creator" should {
    "save a course" in {
      val course = CourseStub.random

      repositoryShouldSaveCourse(course)

      creator.create(course.id, course.title, course.video) should be()
    }
  }
}
