package tv.codely.api_scala_http.module.video.infrastructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import tv.codely.api_scala_http.module.video.domain.Video

object VideoJsValueMarshaller {
  def marshall(videos: Seq[Video]): JsArray = JsArray(
    videos
      .map(
        v =>
          JsObject(
            "id"       -> JsString(v.id.toString),
            "title"    -> JsString(v.title.value),
            "duration" -> JsNumber(v.duration.toSeconds),
            "category" -> JsString(v.category.toString)
        )
      )
      .toVector
  )
}
