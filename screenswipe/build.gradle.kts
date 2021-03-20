plugins {
    ScreenSwipeBuildModule.plugins.forEach { plugin -> id(plugin) }
    ScreenSwipeBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(ScreenSwipeBuildModule.compileSdk)
    buildToolsVersion(ScreenSwipeBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(ScreenSwipeBuildModule.minSdk)
        targetSdkVersion(ScreenSwipeBuildModule.targetSdk)
        versionCode(ScreenSwipeBuildModule.versionCode)
        versionName(ScreenSwipeBuildModule.versionName)

        testInstrumentationRunner = ScreenSwipeBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = ScreenSwipeBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ScreenSwipeBuildModule.compileCompatibility
        targetCompatibility = ScreenSwipeBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = ScreenSwipeBuildModule.jvmTarget
    }
}

dependencies {
    ScreenSwipeBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
