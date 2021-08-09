plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "me.michael"
version = "1.0"

repositories {
    google()
}

dependencies {
    implementation(project(":common"))

    implementation("androidx.activity:activity-compose:1.3.1")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "me.michael.android"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}