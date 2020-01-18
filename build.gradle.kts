import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    }
}


plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.johnrengelman.shadow") version "5.1.0"
    maven
    `maven-publish`
    signing
    id("org.jetbrains.dokka") version "0.9.18"
}

repositories {
    jcenter()
    mavenCentral()
}


version = "0.1"


dependencies {
    compile(gradleApi())
    compile(kotlin("stdlib"))
    compile(kotlin("stdlib-jdk8"))
    compile("com.jessecorbett:diskord-jvm:1.5.3")
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}


tasks.withType<ShadowJar>() {
    manifest {
        attributes["Main-Class"] = "mydomain.mybot.MainKt"
    }
}
