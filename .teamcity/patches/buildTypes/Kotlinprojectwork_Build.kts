package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'Kotlinprojectwork_Build'
in the project with id = 'Kotlinprojectwork', and delete the patch script.
*/
create(RelativeId("Kotlinprojectwork"), BuildType({
    id("Kotlinprojectwork_Build")
    name = "Build"

    vcs {
        root(RelativeId("Kotlinprojectwork_HttpsGithubComAnasthanKotlinprojectGitRefsHeadsMain"))
    }

    triggers {
        vcs {
        }
    }
}))

