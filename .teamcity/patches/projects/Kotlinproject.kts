package patches.projects

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a project with id = 'Kotlinproject'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, Project({
    id("Kotlinproject")
    name = "Kotlinproject"
    archived = true
}))

