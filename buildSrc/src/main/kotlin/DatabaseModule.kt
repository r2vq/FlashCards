import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.ktx
import Dependencies.material
import Dependencies.stdLib

object DatabaseModule : Module() {
    override val plugins = listOf(
        "com.android.library"
    )
    override val kotlinPlugins = listOf(
        "android"
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        material
    )

    override val testImplementations = listOf(
        junit
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
