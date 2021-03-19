plugins {
    ScreenListBuildModule.plugins.forEach { plugin -> id(plugin) }
    ScreenListBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(ScreenListBuildModule.compileSdk)
    buildToolsVersion(ScreenListBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(ScreenListBuildModule.minSdk)
        targetSdkVersion(ScreenListBuildModule.targetSdk)
        versionCode(ScreenListBuildModule.versionCode)
        versionName(ScreenListBuildModule.versionName)

        testInstrumentationRunner = ScreenListBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = ScreenListBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ScreenListBuildModule.compileCompatibility
        targetCompatibility = ScreenListBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenListBuildModule.jvmTarget
    }
}

dependencies {
    ScreenListBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
