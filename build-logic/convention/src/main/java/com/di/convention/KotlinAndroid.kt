package com.di.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = libs.findVersion("compileSdk").get().toString().toInt()

        defaultConfig {
            minSdk = libs.findVersion("minSdk").get().toString().toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        // Retrieve the common extension (either ApplicationExtension or LibraryExtension)
        val androidExtension = project.extensions.findByType(BaseExtension::class.java)

        androidExtension?.apply {
            // Apply generic product flavors for both app and library modules
            configureGenericProductFlavors(this)

            // Common build types for both app and library
            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                }
                getByName("release") {
                    isMinifyEnabled = true
                }
            }

        }

    }

    configureKotlin()


}

internal fun Project.configureKotlinJvm() {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }

    configureKotlin()
}

private fun configureGenericProductFlavors(extension: BaseExtension) {
    extension.apply {
        flavorDimensions("version")
        productFlavors {
            create("development") {
                // Common configuration for the free flavor, applied to both apps and libraries
                dimension = "version"
            }
            create("production") {
                // Common configuration for the paid flavor, applied to both apps and libraries
                dimension = "version"
            }
        }
    }

    // Apply additional app-specific or library-specific configuration
    when (extension) {
        is ApplicationExtension -> configureAppFlavors(extension)
        is LibraryExtension -> configureLibraryFlavors(extension)
    }
}

// App-specific configuration for product flavors
private fun configureAppFlavors(appExtension: ApplicationExtension) {
    appExtension.apply {
        productFlavors {
            getByName("development") {
                applicationIdSuffix = ".dev"
                versionNameSuffix = "-dev"
                resValue("string", "app_name", "MultiModule-development")
            }
            getByName("production") {
                applicationIdSuffix = ""
                versionNameSuffix = ""
            }
        }
    }
}


// Library-specific configuration for product flavors (if needed)
private fun configureLibraryFlavors(libraryExtension: LibraryExtension) {
    libraryExtension.apply {
        productFlavors {
            // If any specific library flavor configurations are needed, they can be added here.
        }
    }
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors.set(warningsAsErrors.toBoolean())
            freeCompilerArgs.addAll(
                listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    // Enable experimental coroutines APIs, including Flow
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-opt-in=kotlinx.coroutines.FlowPreview",
                )
            )

        }
    }
}
