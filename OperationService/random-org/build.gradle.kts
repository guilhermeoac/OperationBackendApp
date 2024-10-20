
plugins {
    id("java")
}

group = "com.ntd.operationservice"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(mapOf("path" to ":output-boundary")))
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
}
