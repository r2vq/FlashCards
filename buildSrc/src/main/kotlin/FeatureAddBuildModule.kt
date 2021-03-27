import Dependencies.appcompat
import Dependencies.constraint
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.material
import Dependencies.navigationFragment
import Dependencies.navigationUi
import Dependencies.paging
import Dependencies.pagingKtx
import Dependencies.pagingTesting
import Dependencies.recyclerView
import Dependencies.stdLib
import Dependencies.viewModel

object FeatureAddBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules = listOf(
        layerCommon,
        layerRepo
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        constraint,
        koin,
        material,
        navigationFragment,
        navigationUi,
        paging,
        pagingKtx,
        recyclerView,
        viewModel
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
