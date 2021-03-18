import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.room
import Dependencies.roomKtx
import Dependencies.stdLib

object RepositoryBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android
    )

    override val localModules = listOf(
        database
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin,
        room,
        roomKtx
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
