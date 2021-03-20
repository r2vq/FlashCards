import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.paging
import Dependencies.pagingKtx
import Dependencies.pagingTesting
import Dependencies.room
import Dependencies.roomKapt
import Dependencies.roomKtx
import Dependencies.stdLib

object DatabaseBuildModule : BuildModule() {
    override val plugins = listOf(
        library
    )
    override val kotlinPlugins = listOf(
        android,
        kapt
    )

    override val localModules: List<String> = listOf(
        common
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin,
        paging,
        pagingKtx,
        room,
        roomKtx
    )

    override val kapts = listOf(
        roomKapt
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
