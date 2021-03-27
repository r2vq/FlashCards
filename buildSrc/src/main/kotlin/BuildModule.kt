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

    protected val featureAdd = ":feature_add"
    protected val featureList = ":feature_list"
    protected val featureSwipe = ":feature_swipe"
    protected val layerCommon = ":layer_common"
    protected val layerDb = ":layer_db"
    protected val layerDi = ":layer_di"
    protected val layerRepo = ":layer_repo"

    val compileSdk = 30
    val buildTools = "30.0.3"
    val minSdk = 19
    val multiDexEnabled = true
    val targetSdk = 30
    val versionCode = 1
    val versionName = "0.0.1-alpha01"
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val isMinifyEnabled = false
    val compileCompatibility = JavaVersion.VERSION_1_8
    val jvmTarget = "1.8"
}
