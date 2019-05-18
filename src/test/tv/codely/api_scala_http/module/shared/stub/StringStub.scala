package tv.codely.api_scala_http.module.shared.stub

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = Random.alphanumeric take numChars mkString ""
}
