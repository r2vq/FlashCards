import org.gradle.api.JavaVersion

abstract class Module {
    abstract val plugins: List<String>
    abstract val kotlinPlugins: List<String>

    abstract val implementations: List<String>
    abstract val kapts: List<String>
    abstract val testImplementations: List<String>
    abstract val androidTestImplementations: List<String>

    val compileSdk = 30
    val buildTools = "30.0.3"
    val minSdk = 19
    val targetSdk = 30
    val versionCode = 1
    val versionName = "0.0.1-alpha01"
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val isMinifyEnabled = false
    val compileCompatibility = JavaVersion.VERSION_1_8
    val jvmTarget = "1.8"
}
