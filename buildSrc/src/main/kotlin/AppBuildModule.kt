import Dependencies.appcompat
import Dependencies.constraint
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.material
import Dependencies.multidex
import Dependencies.navigationFragment
import Dependencies.navigationUi
import Dependencies.paging
import Dependencies.stdLib
import Dependencies.stetho

object AppBuildModule : BuildModule() {
    override val plugins = listOf(
        application
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules: List<String> = listOf(
        common,
        di,
        featureAdd,
        screenlist,
        screenswipe
    )

    override val implementations = listOf(
        stdLib,
        koin,
        ktx,
        appcompat,
        constraint,
        material,
        multidex,
        navigationFragment,
        navigationUi,
        paging,
        stetho
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
