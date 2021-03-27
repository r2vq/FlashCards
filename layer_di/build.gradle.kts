plugins {
    LayerDIBuildModule.plugins.forEach { plugin -> id(plugin) }
    LayerDIBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(LayerDIBuildModule.compileSdk)
    buildToolsVersion(LayerDIBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(LayerDIBuildModule.minSdk)
        targetSdkVersion(LayerDIBuildModule.targetSdk)
        versionCode(LayerDIBuildModule.versionCode)
        versionName(LayerDIBuildModule.versionName)

        testInstrumentationRunner = LayerDIBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = LayerDIBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = LayerDIBuildModule.compileCompatibility
        targetCompatibility = LayerDIBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = LayerDIBuildModule.jvmTarget
    }
}

dependencies {
    LayerDIBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
