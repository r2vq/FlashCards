import Dependencies.appcompat
import Dependencies.constraint
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.material
import Dependencies.paging
import Dependencies.stdLib

object AppBuildModule : BuildModule() {
    override val plugins = listOf(
        application
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules: List<String> = listOf(
        di,
        viewmodel
    )

    override val implementations = listOf(
        stdLib,
        koin,
        ktx,
        appcompat,
        constraint,
        material,
        paging
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
