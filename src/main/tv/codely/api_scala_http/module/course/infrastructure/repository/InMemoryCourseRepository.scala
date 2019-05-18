package tv.codely.api_scala_http.module.course.infrastructure.repository

import tv.codely.api_scala_http.module.course.domain.{Course, CourseRepository}
import tv.codely.api_scala_http.module.video.domain
import tv.codely.api_scala_http.module.video.domain.Video

import scala.concurrent.duration._

final class InMemoryCourseRepository extends CourseRepository{
  private var courses = Seq(
    Course(
      id = "e295ecdf-ba69-4672-a34f-400bfc3473df",
      title = "Intro to Scala",
      Video(
        id = "2bccec03-c15d-46dd-9884-d0d8e554ed56",
        title = "What is Functional Programming",
        duration = 30.minutes,
        category = "Screencast"
      )
    ),
    Course(
      id = "bf4e10d4-7a89-4e59-8bda-872ee8f61e78",
      title = "SOLID Principles",
      domain.Video(
        id = "43f19a9c-4bc4-42e8-bace-44c0707ed87f",
        title = "Introduction to SOLID Principles",
        duration = 20.minutes,
        category = "Screencast"
      )
    )
  )
  def all(): Seq[Course] = courses

  def save(course: Course): Unit = courses = courses :+ course
}
