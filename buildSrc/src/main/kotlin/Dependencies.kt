object Dependencies {
    // project
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // kotlin
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    // android
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    // constraint
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // database
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // material
    const val material = "com.google.android.material:material:${Versions.material}"

    // testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
