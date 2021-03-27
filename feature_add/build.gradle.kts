plugins {
    FeatureAddBuildModule.plugins.forEach { plugin -> id(plugin) }
    FeatureAddBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(FeatureAddBuildModule.compileSdk)
    buildToolsVersion(FeatureAddBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(FeatureAddBuildModule.minSdk)
        targetSdkVersion(FeatureAddBuildModule.targetSdk)
        versionCode(FeatureAddBuildModule.versionCode)
        versionName(FeatureAddBuildModule.versionName)

        testInstrumentationRunner = FeatureAddBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = FeatureAddBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = FeatureAddBuildModule.compileCompatibility
        targetCompatibility = FeatureAddBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = FeatureAddBuildModule.jvmTarget
    }
}

dependencies {
    FeatureAddBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
