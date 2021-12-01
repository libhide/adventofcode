import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.ratik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testApi("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.assertj:assertj-core:3.21.0")
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