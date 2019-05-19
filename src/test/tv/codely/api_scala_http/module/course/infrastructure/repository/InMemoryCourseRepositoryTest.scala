package tv.codely.api_scala_http.module.course.infrastructure.repository

import tv.codely.api_scala_http.module.course.CourseIntegrationTestCase
import tv.codely.api_scala_http.module.course.domain.CourseStub

final class InMemoryCourseRepositoryTest extends CourseIntegrationTestCase{
  "In memory course repository" should {
    "search all existing courses" in {
      val course = CourseStub.random
      val anotherCourse = CourseStub.random
      val existingCourses = Seq(course, anotherCourse)

      repository.save(course)
      repository.save(anotherCourse)

      repository.all() should be(existingCourses)
    }
  }

}
