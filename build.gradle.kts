@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "cl.ravenhill"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.kotest:kotest-property:5.5.1")
    implementation("io.kotest:kotest-assertions-core:5.5.1")
    implementation("io.kotest:kotest-runner-junit5:5.5.1")
    implementation("com.github.stefanbirkner:system-lambda:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}