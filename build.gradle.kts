// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.6.1" apply false
    id("com.android.library") version "8.6.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.0"
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
}

allprojects {
    version = "0.1.4"
    group = "com.github.cespaul"
}

subprojects {
    apply(plugin = "maven-publish")
}