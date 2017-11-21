import org.gradle.kotlin.dsl.version
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    // repeated below
    val junitPlatformVersion by extra {"1.0.2"}

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

plugins {
    kotlin("jvm") version "1.1.60"
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

repositories {
    mavenCentral()
}

// repeated above
val junitPlatformVersion by extra {"1.0.2"}
val junitJupiterVersion by extra {"5.0.2"}

dependencies {
    compile(kotlin("stdlib-jre8"))

    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
}

val javaVersion by extra {JavaVersion.VERSION_1_8}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }
}