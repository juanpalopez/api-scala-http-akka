package tv.codely.api_scala_http.module.shared.stub

import scala.concurrent.duration._

object DurationStub {
  def random: Duration = IntStub.randomUnsigned().minutes
}
