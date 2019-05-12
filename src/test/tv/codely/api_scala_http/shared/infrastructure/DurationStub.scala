package tv.codely.api_scala_http.shared.infrastructure

import scala.concurrent.duration._

object DurationStub {
  def random: Duration = IntStub.randomUnsigned().minutes
}
