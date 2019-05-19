package tv.codely.api_scala_http.entry_point

import tv.codely.api_scala_http.entry_point.controller.course.{CourseGetController, CoursePostController}
import tv.codely.api_scala_http.entry_point.controller.status.StatusGetController
import tv.codely.api_scala_http.entry_point.controller.user.{UserGetController, UserPostController}
import tv.codely.api_scala_http.entry_point.controller.video.{VideoGetController, VideoPostController}
import tv.codely.api_scala_http.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.api_scala_http.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.api_scala_http.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
    userDependencies: UserModuleDependencyContainer,
    videoDependencies: VideoModuleDependencyContainer,
    courseDependencies: CourseModuleDependencyContainer
) {
  val statusGetController = new StatusGetController
  val userGetController   = new UserGetController(userDependencies.usersSearcher)
  val userPostController  = new UserPostController(userDependencies.userCreator)

  val videoGetController  = new VideoGetController(videoDependencies.videosSearcher)
  val videoPostController = new VideoPostController(videoDependencies.videoCreator)

  val courseGetController  = new CourseGetController(courseDependencies.coursesSearcher)
  val coursePostController = new CoursePostController(courseDependencies.courseCreator)
}
