plugins {
    LayerRepoBuildModule.plugins.forEach { plugin -> id(plugin) }
    LayerRepoBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(LayerRepoBuildModule.compileSdk)
    buildToolsVersion(LayerRepoBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(LayerRepoBuildModule.minSdk)
        targetSdkVersion(LayerRepoBuildModule.targetSdk)
        versionCode(LayerRepoBuildModule.versionCode)
        versionName(LayerRepoBuildModule.versionName)

        testInstrumentationRunner = LayerRepoBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = LayerRepoBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = LayerRepoBuildModule.compileCompatibility
        targetCompatibility = LayerRepoBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = LayerRepoBuildModule.jvmTarget
    }
}

dependencies {
    LayerRepoBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
