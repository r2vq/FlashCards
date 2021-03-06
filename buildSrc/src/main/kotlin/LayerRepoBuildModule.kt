import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.paging
import Dependencies.pagingKtx
import Dependencies.pagingTesting
import Dependencies.stdLib

object LayerRepoBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules = listOf(
        layerCommon,
        layerDb
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin,
        paging,
        pagingKtx
    )

    override val kapts = listOf<String>(
    )

    override val testImplementations = listOf(
        junit,
        pagingTesting
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
