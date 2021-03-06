object Dependencies {
    // project
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // kotlin
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    // android
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val liveDataTesting = "androidx.arch.core:core-testing:${Versions.arch}"
    const val multidex = "com.android.support:multidex:${Versions.multidex}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val saveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // card swipe view
    const val cardStackView = "com.yuyakaido.android:card-stack-view:${Versions.cardStackView}"

    // constraint
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // database
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    // dependency injection
    const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // material
    const val material = "com.google.android.material:material:${Versions.material}"

    // navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"

    // paging
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
    const val pagingKtx = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val pagingTesting = "androidx.paging:paging-common:${Versions.paging}"

    // testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
