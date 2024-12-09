plugins {
    java
    `maven-publish`
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.7.4"
    id ("io.freefair.lombok") version "6.6-rc1"
}

group = "tv.niure.detailedevents"
version = "1.0.12"

apply(plugin = "java")
apply(plugin = "maven-publish")
apply(plugin = "java-library")
apply(plugin = "io.papermc.paperweight.userdev")
apply(plugin = "io.freefair.lombok")

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/") //Paper
    maven("https://repo.dmulloy2.net/repository/public/") //Spigot
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}

dependencies {
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}