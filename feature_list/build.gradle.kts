plugins {
    FeatureListBuildModule.plugins.forEach { plugin -> id(plugin) }
    FeatureListBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(FeatureListBuildModule.compileSdk)
    buildToolsVersion(FeatureListBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(FeatureListBuildModule.minSdk)
        targetSdkVersion(FeatureListBuildModule.targetSdk)
        versionCode(FeatureListBuildModule.versionCode)
        versionName(FeatureListBuildModule.versionName)

        testInstrumentationRunner = FeatureListBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = FeatureListBuildModule.isMinifyEnabled
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = FeatureListBuildModule.compileCompatibility
        targetCompatibility = FeatureListBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = FeatureListBuildModule.jvmTarget
    }
}

dependencies {
    FeatureListBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
