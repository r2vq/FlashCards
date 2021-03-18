import Dependencies.appcompat
import Dependencies.constraint
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.ktx
import Dependencies.material
import Dependencies.stdLib
import org.gradle.api.JavaVersion

object AppModule : Module {
    const val compileSdk = 30
    const val buildTools = "30.0.3"

    const val minSdk = 19
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "0.0.1-alpha01"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val isMinifyEnabled = false

    val compileCompatibility = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"

    override val plugins = listOf(
        "com.android.application"
    )
    override val kotlinPlugins = listOf(
        "android"
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        material,
        constraint
    )

    override val testImplementations = listOf(
        junit
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
