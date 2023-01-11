group = "dev.hoepelman.kjson-schema"
version = "0.0.1"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version Version.Kotlin
    kotlin("plugin.serialization") version Version.Kotlin
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${Version.KotlinxSerialization}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.KotlinxSerialization}")
    implementation(kotlin("reflect"))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {

    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.apiVersion = "1.8"
    kotlinOptions.languageVersion = "1.8"
    //kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}


tasks.named<Test>("test") {
   useJUnitPlatform()
//   filter {
//      isFailOnNoMatchingTests = false
//   }
   testLogging {
      showExceptions = true
      showStandardStreams = true
      events = setOf(
         org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
         org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
      )
      exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
   }
}
