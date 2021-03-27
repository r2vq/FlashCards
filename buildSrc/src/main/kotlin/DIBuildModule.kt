import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.stdLib

object DIBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules = listOf(
        database,
        repository,
        featureAdd,
        featureList,
        screenswipe
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin
    )

    override val kapts = listOf<String>(
    )

    override val testImplementations = listOf(
        junit
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
