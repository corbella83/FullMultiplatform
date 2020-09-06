
val popkornVersion = "2.0.0"
val appCompatVersion = "1.2.0"

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

group = "cat.corbella"
version = "1.0"

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("cc.popkorn:popkorn:$popkornVersion")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "me.corbella.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}