package tv.codely.api_scala_http.module.course.domain

trait CourseRepository {
  def all(): Seq[Course]
  def save(course: Course):Unit
}
