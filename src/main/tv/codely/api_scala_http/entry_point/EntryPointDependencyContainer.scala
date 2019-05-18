package tv.codely.api_scala_http.entry_point

import tv.codely.api_scala_http.entry_point.controller.course.CourseGetController
import tv.codely.api_scala_http.entry_point.controller.status.StatusGetController
import tv.codely.api_scala_http.entry_point.controller.user.UserGetController
import tv.codely.api_scala_http.entry_point.controller.video.VideoGetController
import tv.codely.api_scala_http.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.api_scala_http.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.api_scala_http.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
  userDependencies: UserModuleDependencyContainer,
  videoDependencies: VideoModuleDependencyContainer,
  courseDependencies: CourseModuleDependencyContainer
){
  val statusGetController = new StatusGetController
  val userGetController = new UserGetController(userDependencies.usersSearcher)
  val videoGetController = new VideoGetController(videoDependencies.videosSearcher)
  val courseGetController = new CourseGetController(courseDependencies.coursesSearcher)
}
