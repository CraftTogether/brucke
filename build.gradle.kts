import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "dev.polarian"
version = "1.0-SNAPSHOT-1"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
    compileOnly("com.github.CraftTogether:Kelp:1.2-SNAPSHOT-4")
    implementation("com.gitlab.PolarianDev:ircj:1.1-SNAPSHOT-14")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.4")
    implementation("org.json:json:20211205")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

application {
    mainClass.set("MainKt")
}