import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("com.github.johnrengelman.shadow") version "7.1.1"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.springframework:spring-context:5.2.21.RELEASE")
    implementation("org.springframework:spring-webmvc:6.0.9")
    implementation("org.springframework:spring-jdbc:5.2.3.RELEASE")
    implementation("org.springframework.kafka:spring-kafka:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter:3.1.1")
}
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("/home/roman/ITMessenger.jar")
}
tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.2")
}