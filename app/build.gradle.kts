import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.dsl.BuildType
import com.android.builder.core.DefaultApiVersion
import com.android.builder.core.DefaultProductFlavor
import com.android.builder.model.ApiVersion

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

import org.jetbrains.kotlin.gradle.plugin.KotlinAndroidPluginWrapper

import java.lang.System

plugins {
    kotlin("android") version "1.1.51"
    kotlin("android.extensions") version "1.1.51"
}

android {
    compileSdkVersion(27)
    defaultConfig {
        applicationId = "h3.birth.app.kotlinfeststudy"
        minSdkVersion(21)
        targetSdkVersion(27)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
    }
}

val kotlinVersion: String by extra

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version")
    implementation("com.android.support:appcompat-v7:27.1.1")
    implementation("com.android.support.constraint:constraint-layout:1.1.2")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}