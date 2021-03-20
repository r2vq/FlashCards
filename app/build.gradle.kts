plugins {
    AppBuildModule.plugins.forEach { plugin -> id(plugin) }
    AppBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(AppBuildModule.compileSdk)
    buildToolsVersion(AppBuildModule.buildTools)

    defaultConfig {
        applicationId = "com.keanequibilan.flashcards"
        minSdkVersion(AppBuildModule.minSdk)
        multiDexEnabled = AppBuildModule.multiDexEnabled
        targetSdkVersion(AppBuildModule.targetSdk)
        versionCode(AppBuildModule.versionCode)
        versionName(AppBuildModule.versionName)

        testInstrumentationRunner = AppBuildModule.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = AppBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppBuildModule.compileCompatibility
        targetCompatibility = AppBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = AppBuildModule.jvmTarget
    }
}

dependencies {
    AppBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
