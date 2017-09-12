import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    // repeated below
    val kotlinVersion by extra {"1.1.4-3"}
    val junitPlatformVersion by extra {"1.0.0-RC3"}

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

plugins {
    kotlin("jvm")
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

repositories {
    mavenCentral()
}

// repeated above
val kotlinVersion by extra {"1.1.4-3"}
val junitPlatformVersion by extra {"1.0.0-RC3"}
val junitJupiterVersion by extra {"5.0.0-RC3"}

dependencies {
    compile(kotlin("stdlib-jre8", kotlinVersion))

    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
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