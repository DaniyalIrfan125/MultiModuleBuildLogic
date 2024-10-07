import com.android.build.api.dsl.ApplicationExtension
import com.di.convention.configureKotlinAndroid
import com.di.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("MultiModuleBuildLogic.android.lint")
            }

            extensions.configure<ApplicationExtension> {
                  configureKotlinAndroid(this)


                defaultConfig.targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
            }

        }
    }
}