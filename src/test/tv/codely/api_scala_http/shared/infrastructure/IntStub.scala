package tv.codely.api_scala_http.shared.infrastructure

import scala.util.Random

object IntStub {
  def random: Int = Random.nextInt()

  def randomUnsigned(max: Int = Int.MaxValue - 1): Int = randomBetween(min = 0, max = max)

  def randomBetween(min: Int, max: Int): Int = Random.nextInt((max - min) + 1)
}
