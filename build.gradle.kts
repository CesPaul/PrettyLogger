// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.7.20"
}

allprojects {
    version = "0.1.3"
    group = "com.github.cespaul"
}

subprojects {
    apply(plugin = "maven-publish")

//    publishing {
//        publications {
//            maven(MavenPublication) {
//                groupId = project.group
//                artifactId = project.name
//                version = project.version
//            }
//        }
//    }
}