package tv.codely.api_scala_http.video.domain

object VideoCategory {
  def apply(value: String): VideoCategory = value match {
    case "Screencast" => Screencast
    case "Interview"  => Interview
    case _            => throw new RuntimeException(s"Video category not recognized <$value>.")

  }
}

sealed trait VideoCategory

case object Screencast extends VideoCategory
case object Interview  extends VideoCategory
