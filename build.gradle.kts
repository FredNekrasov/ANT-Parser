plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
}
group = "org.fredProjects"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    // network
    implementation("io.ktor:ktor-client-core:2.3.10")
    implementation("io.ktor:ktor-client-cio:2.3.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.10")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.10")
    // html parser
    implementation("org.jsoup:jsoup:1.17.2")
    // DI
    implementation("io.insert-koin:koin-core:3.5.6")
    testImplementation(kotlin("test"))
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}