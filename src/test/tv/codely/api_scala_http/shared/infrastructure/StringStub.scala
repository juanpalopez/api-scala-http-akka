package tv.codely.api_scala_http.shared.infrastructure

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = Random.alphanumeric take numChars mkString ""
}
