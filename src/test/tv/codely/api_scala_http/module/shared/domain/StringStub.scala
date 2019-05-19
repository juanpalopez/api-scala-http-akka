package tv.codely.api_scala_http.module.shared.domain

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = Random.alphanumeric take numChars mkString ""
}
