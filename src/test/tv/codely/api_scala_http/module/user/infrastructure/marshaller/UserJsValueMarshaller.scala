package tv.codely.api_scala_http.module.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import tv.codely.api_scala_http.module.user.domain.User

object UserJsValueMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users
      .map(
        u =>
          JsObject(
            "id"   -> JsString(u.id.toString),
            "name" -> JsString(u.name.value)
        ))
      .toVector
  )
}
