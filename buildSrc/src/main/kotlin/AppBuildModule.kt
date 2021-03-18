import Dependencies.appcompat
import Dependencies.constraint
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.ktx
import Dependencies.material
import Dependencies.stdLib

object AppBuildModule : BuildModule() {
    override val plugins = listOf(
        "com.android.application"
    )
    override val kotlinPlugins = listOf(
        "android"
    )

    override val localModules: List<String> = listOf(
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        material,
        constraint
    )

    override val kapts: List<String> = listOf(
    )

    override val testImplementations = listOf(
        junit
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
