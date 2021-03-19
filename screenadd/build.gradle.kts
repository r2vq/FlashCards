plugins {
    ScreenAddBuildModule.plugins.forEach { plugin -> id(plugin) }
    ScreenAddBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(ScreenAddBuildModule.compileSdk)
    buildToolsVersion(ScreenAddBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(ScreenAddBuildModule.minSdk)
        targetSdkVersion(ScreenAddBuildModule.targetSdk)
        versionCode(ScreenAddBuildModule.versionCode)
        versionName(ScreenAddBuildModule.versionName)

        testInstrumentationRunner = ScreenAddBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = ScreenAddBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ScreenAddBuildModule.compileCompatibility
        targetCompatibility = ScreenAddBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenAddBuildModule.jvmTarget
    }
}

dependencies {
    ScreenAddBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
