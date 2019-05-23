package tv.codely.api_scala_http.module.course.infrastructure

import java.util.UUID

import spray.json.DefaultJsonProtocol._
import spray.json.{DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}
import tv.codely.api_scala_http.module.course.domain.{Course, CourseDescription, CourseId, CourseTitle}

object CourseMarshaller {
  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object CourseIdMarshaller extends JsonFormat[CourseId] {
    def write(value: CourseId): JsValue = JsString(value.toString)

    def read(value: JsValue): CourseId = value match {
      case JsString(id) => CourseId(id)
      case _            => throw spray.json.DeserializationException("Expected 1 String for CourseId")

    }
  }

  implicit object CourseTitleMarshaller extends JsonFormat[CourseTitle] {
    def write(value: CourseTitle): JsValue = JsString(value.value)

    def read(value: JsValue): CourseTitle = value match {
      case JsString(title) => CourseTitle(title)
      case _               => throw spray.json.DeserializationException("Expected 1 String for CourseTitle")

    }
  }

  implicit object CourseDescriptionMarshaller extends JsonFormat[CourseDescription] {
    def write(value: CourseDescription): JsValue = JsString(value.value)

    def read(value: JsValue): CourseDescription = value match {
      case JsString(description) => CourseDescription(description)
      case _                     => throw spray.json.DeserializationException("Expected 1 String for CourseDescription")

    }
  }

  implicit val courseFormat: RootJsonFormat[Course] = jsonFormat3(
    Course.apply(_: CourseId, _: CourseTitle, _: CourseDescription))
}
