package tv.codely.api_scala_http.module.course.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import tv.codely.api_scala_http.module.course.domain.Course

object CourseJsValueMarshaller {
  def marshall(courses: Seq[Course]): JsArray = JsArray(
    courses
      .map(
        c =>
          JsObject(
            "id"    -> JsString(c.id.toString),
            "title" -> JsString(c.title.value),
            "description" -> JsString(c.description.value)
            )
        ).toVector

  )
}
