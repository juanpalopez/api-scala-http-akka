package tv.codely.api_scala_http.module.course.application

import tv.codely.api_scala_http.module.course.CourseUnitTestCase
import tv.codely.api_scala_http.module.course.domain.CourseStub

final class CourseSearcherTest extends  CourseUnitTestCase{
  private val searcher = new CoursesSearcher(repository)

  "Courses Searcher" should {
    "search all existing courses" in {
      val existingCourse = CourseStub.random
      val anotherExistingCourse = CourseStub.random
      val existingCourses = Seq(existingCourse,anotherExistingCourse)


      repositoryShouldSearchAllCourses(existingCourses)
      searcher.all() shouldBe existingCourses
    }
  }

}
