import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

val popkornVersion = "2.0.0"
val coroutinesVersion = "1.3.7"
val ktorVersion = "1.4.0"
val serializerVersion = "1.0.0-RC"


plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    kotlin("kapt")
}

group = "cat.corbella"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm("android")

    iosX64("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }


    sourceSets {
        val commonMain by getting {
            configurations["kapt"].dependencies.add(project.dependencies.create("cc.popkorn:popkorn-compiler:$popkornVersion"))
            kotlin.srcDir("build/generated/source/kaptKotlin")

            dependencies {
                implementation("cc.popkorn:popkorn:$popkornVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializerVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
            }
        }
        val commonTest by getting { }

        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        val androidTest by getting

        val iosMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }
        val iosTest by getting
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>("ios").binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("assemble").dependsOn(packForXcode)
