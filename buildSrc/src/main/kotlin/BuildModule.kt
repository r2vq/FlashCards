import org.gradle.api.JavaVersion

abstract class BuildModule {
    protected val application = "com.android.application"
    protected val library = "com.android.library"
    protected val android = "android"
    protected val kapt = "kapt"

    abstract val plugins: List<String>
    abstract val kotlinPlugins: List<String>

    abstract val localModules: List<String>
    abstract val implementations: List<String>
    abstract val kapts: List<String>
    abstract val testImplementations: List<String>
    abstract val androidTestImplementations: List<String>

    protected val database = ":database"
    protected val di = ":di"
    protected val repository = ":repository"
    protected val screenadd = ":screenadd"
    protected val screenlist = ":screenlist"

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
