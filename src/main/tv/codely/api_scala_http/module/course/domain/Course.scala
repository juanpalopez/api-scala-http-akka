package tv.codely.api_scala_http.module.course.domain

object Course {
  def apply(id: String, title: String, description: String): Course =
    Course(CourseId(id), CourseTitle(title), CourseDescription(description))
}

case class Course(id: CourseId, title: CourseTitle, description: CourseDescription)
