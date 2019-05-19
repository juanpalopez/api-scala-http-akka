package tv.codely.api_scala_http.module

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpec}

protected[api_scala_http] trait UnitTestCase extends WordSpec with Matchers with MockFactory {}
