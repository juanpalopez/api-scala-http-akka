package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model._

final class StatusSpec extends AcceptanceSpec {
  "Scala Http Api" should {
    "respond successfully while requesting its status" in get("/status") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String] shouldBe """{"status":"ok"}"""
    }
  }
}
