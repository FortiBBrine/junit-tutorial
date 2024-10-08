plugins {
    id("java")
}

group = "me.fortibrine"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.mockito:mockito-core:5.13.0")

    testImplementation("org.assertj:assertj-core:3.26.3")

//    testImplementation("org.powermock:powermock-module-junit4:2.0.9")

}

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        targetCompatibility = "17"
        sourceCompatibility = "17"
    }

    jar {

        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from (
            configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
        )

    }

    test {
        useJUnitPlatform()
    }

}