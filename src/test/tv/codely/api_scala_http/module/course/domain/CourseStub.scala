package tv.codely.api_scala_http.module.course.domain

object CourseStub {
  def apply(id: String = CourseIdStub.random.toString,
            title: String = CourseTitleStub.random.toString,
            description: String = CourseDescriptionStub.random.toString): Course = Course(id, title, description)

  def random: Course = apply()
}
