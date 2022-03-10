import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {
    description = "Contains all other projects"

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
        dockerRegistry {
            id = "PROJECT_EXT_5"
            name = "DockerHub"
            url = "https://docker.io"
            userName = "ankitasthanaepam"
            password = "credentialsJSON:f99bc9df-5c38-420d-a9a9-b0426bfd1ad4"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(JavaAppMaster)
}


object JavaAppMaster : Project({
    name = "Java App Master"

    vcsRoot(JavaAppMaster_HttpsGithubComAnasthanJavaAppMasterGitRefsHeadsMain)

    buildType(JavaAppMaster_Clean)
})

object JavaAppMaster_Clean : BuildType({
    name = "Clean"

    vcs {
        root(JavaAppMaster_HttpsGithubComAnasthanJavaAppMasterGitRefsHeadsMain)
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
            quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_CUSTOM
            quietPeriod = 30
            perCheckinTriggering = true
            enableQueueOptimization = false
        }
    }
})

object JavaAppMaster_HttpsGithubComAnasthanJavaAppMasterGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/anasthan/java-app-master.git#refs/heads/main"
    url = "https://github.com/anasthan/java-app-master.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "ankit.asthana49@hotmail.com"
        password = "credentialsJSON:7cbaf38c-f013-4a17-b458-ea8f11c94694"
    }
})
