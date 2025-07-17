plugins {
    kotlin("jvm")
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

group = "com.github.cespaul.prettylogger"
version = "0.1.4"


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}


publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
            artifactId = "ktor_jvm"
        }
    }
}

dependencies {
    implementation("io.ktor:ktor-client-logging:2.3.4")
    implementation("com.google.code.gson:gson:2.11.0")
}