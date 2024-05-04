plugins {
    kotlin("jvm") version "1.9.23"
}
group = "org.fredProjects"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    implementation("io.ktor:ktor-client-core:2.3.10")
    implementation("io.ktor:ktor-client-cio:2.3.10")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("io.insert-koin:koin-core:3.5.6")
    testImplementation(kotlin("test"))
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}