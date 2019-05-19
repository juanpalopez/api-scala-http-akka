package tv.codely.api_scala_http.module.shared.domain

import scala.concurrent.duration._

object DurationStub {
  def random: Duration = IntStub.randomUnsigned().seconds
}
