import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.lifecycleCompiler
import Dependencies.liveData
import Dependencies.liveDataTesting
import Dependencies.saveState
import Dependencies.stdLib
import Dependencies.viewModel

object ViewModelBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android,
        kapt
    )

    override val localModules = listOf(
        repository
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin,
        liveData,
        saveState,
        viewModel
    )

    override val kapts = listOf(
        lifecycleCompiler
    )

    override val testImplementations = listOf(
        junit,
        liveDataTesting
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
