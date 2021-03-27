plugins {
    LayerDbBuildModule.plugins.forEach { plugin -> id(plugin) }
    LayerDbBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(LayerDbBuildModule.compileSdk)
    buildToolsVersion(LayerDbBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(LayerDbBuildModule.minSdk)
        targetSdkVersion(LayerDbBuildModule.targetSdk)
        versionCode(LayerDbBuildModule.versionCode)
        versionName(LayerDbBuildModule.versionName)

        testInstrumentationRunner = LayerDbBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = LayerDbBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = LayerDbBuildModule.compileCompatibility
        targetCompatibility = LayerDbBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = LayerDbBuildModule.jvmTarget
    }
}

dependencies {
    LayerDbBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
