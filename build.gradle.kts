import com.sun.javafx.PlatformUtil.isWindows
import org.apache.commons.io.output.ByteArrayOutputStream
import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories
import sun.rmi.runtime.Log

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlin_version by extra { "1.2.61" }
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("org.jmailen.gradle:kotlinter-gradle:1.16.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}

fun countUsage(target: String): Int {
    val byteArrayOutputStream = ByteArrayOutputStream()
    exec {
        if (isWindows()) {
            executable = "cmd"
        } else {
            executable = "sh"
        }
        args("-c", "git grep -l '$target' | wc -l")
        standardOutput = byteArrayOutputStream
    }
    return byteArrayOutputStream.toString().trim().toIntOrNull() ?: 0
}

task("removeUnusedDrawable") {
    doLast {
        File(rootDir.absolutePath + "/app/src/main/res").walkTopDown().filter {
            it.isFile
        }.filter {
            it.parent.contains("drawable")
        }.filter {
            it.name.endsWith(".png") || it.name.endsWith(".xml")
        }.forEach {
            val name = it.name.substringBefore(".")
            val count1 = countUsage("@drawable/$name")
            val count2 = countUsage("R.drawable.$name")
            if (count1 == 0 && count2 == 0) {
                it.delete()
            }
        }
    }
}

task("helloDSL") {
    doLast {
        println("helloDSL")
    }
}