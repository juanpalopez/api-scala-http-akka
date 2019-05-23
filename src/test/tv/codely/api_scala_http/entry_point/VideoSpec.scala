package tv.codely.api_scala_http.entry_point

import akka.http.scaladsl.model._
import spray.json._
import tv.codely.api_scala_http.module.video.domain.VideoStub
import tv.codely.api_scala_http.module.video.infrastructure.marshaller.VideoJsValueMarshaller

import scala.concurrent.duration._

final class VideoSpec extends AcceptanceSpec {
  "save a video" in post(
    "/videos",
    """
      |{
      |  "id": "a11098af-d352-4cce-8372-2b48b97e6942",
      |  "title": "🎥 Entrevista a SergiGP, de troll a developer!",
      |  "duration_in_seconds": 15,
      |  "category": "Interview",
      |  "courseId": "e295ecdf-ba69-4672-a34f-400bfc3473df"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the system video when request GET /videos" in {
    get("/videos") {
      val expectedVideos = Seq(
        VideoStub(
          id = "a11098af-d352-4cce-8372-2b48b97e6942",
          title = "🎥 Entrevista a SergiGP, de troll a developer!",
          duration = 15.seconds,
          category = "Interview",
          courseId = "e295ecdf-ba69-4672-a34f-400bfc3473df"
        )
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe VideoJsValueMarshaller.marshall(expectedVideos)
    }
  }
}
