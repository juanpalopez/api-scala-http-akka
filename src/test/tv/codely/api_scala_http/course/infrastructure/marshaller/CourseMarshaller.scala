package tv.codely.api_scala_http.course.infrastructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import tv.codely.api_scala_http.course.domain.Course

object CourseMarshaller {
  def marshall(courses: Seq[Course]): JsArray = JsArray(
    courses
      .map(
        c =>
          JsObject(
            "id"    -> JsString(c.id.toString),
            "title" -> JsString(c.title.value),
            "video" -> JsObject(
              "id"       -> JsString(c.video.id.toString),
              "title"    -> JsString(c.video.title.value),
              "duration" -> JsNumber(c.video.duration.toSeconds),
              "category" -> JsString(c.video.category.toString)
            ) /*VideoMarshaller.marshall(Seq(c.video))*/
        )
      )
      .toVector
  )
}
