import Dependencies.appcompat
import Dependencies.espressoCore
import Dependencies.junit
import Dependencies.junitExt
import Dependencies.koin
import Dependencies.ktx
import Dependencies.material
import Dependencies.room
import Dependencies.roomKapt
import Dependencies.roomKtx
import Dependencies.stdLib

object DatabaseModule : Module() {
    override val plugins = listOf(
        "com.android.library"
    )
    override val kotlinPlugins = listOf(
        "android",
        "kapt"
    )

    override val implementations = listOf(
        stdLib,
        ktx,
        appcompat,
        koin,
        material,
        room,
        roomKtx
    )

    override val kapts = listOf(
        roomKapt
    )

    override val testImplementations = listOf(
        junit
    )

    override val androidTestImplementations = listOf(
        junitExt,
        espressoCore
    )
}
