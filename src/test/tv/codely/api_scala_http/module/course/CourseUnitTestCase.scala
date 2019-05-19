package tv.codely.api_scala_http.module.course

import tv.codely.api_scala_http.module.UnitTestCase
import tv.codely.api_scala_http.module.course.domain.{Course, CourseRepository}

protected[course] trait CourseUnitTestCase extends UnitTestCase{
  protected val repository: CourseRepository = mock[CourseRepository]

  protected def shouldSaveCourse(course: Course): Unit =
    (repository.save _)
    .expects(course)
    .returning()

  protected def shouldSearchAllCourses(courses:Seq[Course]): Unit=
    (repository.all _)
    .expects()
    .returning(courses)
}
