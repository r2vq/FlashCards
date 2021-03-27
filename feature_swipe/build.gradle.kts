plugins {
    FeatureSwipeBuildModule.plugins.forEach { plugin -> id(plugin) }
    FeatureSwipeBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(FeatureSwipeBuildModule.compileSdk)
    buildToolsVersion(FeatureSwipeBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(FeatureSwipeBuildModule.minSdk)
        targetSdkVersion(FeatureSwipeBuildModule.targetSdk)
        versionCode(FeatureSwipeBuildModule.versionCode)
        versionName(FeatureSwipeBuildModule.versionName)

        testInstrumentationRunner = FeatureSwipeBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = FeatureSwipeBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = FeatureSwipeBuildModule.compileCompatibility
        targetCompatibility = FeatureSwipeBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = FeatureSwipeBuildModule.jvmTarget
    }
}

dependencies {
    FeatureSwipeBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
