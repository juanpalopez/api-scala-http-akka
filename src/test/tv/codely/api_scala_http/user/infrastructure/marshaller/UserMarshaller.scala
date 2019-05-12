package tv.codely.api_scala_http.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import tv.codely.api_scala_http.user.domain.User

object UserMarshaller {
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
