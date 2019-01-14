object Version {
  const val SPEK = "2.0.0-rc.1"
  const val MOCKK = "1.9"
  const val MOCKITO = "2.23.4"

  const val JUNIT = "5.3.2"
}

buildscript {
  repositories {
    mavenCentral()
  }
}

plugins {
  application
  kotlin("jvm") version "1.3.11"
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  testCompile("org.jetbrains.kotlin:kotlin-test")

  testCompile("io.mockk:mockk:${Version.MOCKK}")

  testCompile("org.mockito:mockito-core:${Version.MOCKITO}")

  testCompile("org.junit.jupiter:junit-jupiter-api:${Version.JUNIT}")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:${Version.JUNIT}")

  testCompile("org.spekframework.spek2:spek-dsl-jvm:${Version.SPEK}") {
    exclude(group = "org.jetbrains.kotlin")
  }

  testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:${Version.SPEK}") {
    exclude(group = "org.jetbrains.kotlin")
    exclude(group = "org.junit.platform")
  }
}

application {
  mainClassName = "playground.MainKt"
}

tasks {
  test {
    useJUnitPlatform {
      includeEngines("spek2")
    }
  }
}
