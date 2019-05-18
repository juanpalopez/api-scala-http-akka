package tv.codely.api_scala_http.entry_point

import spray.json._
import akka.http.scaladsl.model._
import tv.codely.api_scala_http.module.user.infrastructure.marshaller.UserJsValueMarshaller
import tv.codely.api_scala_http.module.user.infrastructure.stub.UserStub

final class UserSpec extends AcceptanceSpec {
  "return a list the system users when request GET /users" in {
    get("/users")  {
      val expectedUsers = Seq(
        UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
        UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserJsValueMarshaller.marshall(expectedUsers)
    }
  }
}