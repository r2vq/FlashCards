plugins {
    ViewModelBuildModule.plugins.forEach { plugin -> id(plugin) }
    ViewModelBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(ViewModelBuildModule.compileSdk)
    buildToolsVersion(ViewModelBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(ViewModelBuildModule.minSdk)
        targetSdkVersion(ViewModelBuildModule.targetSdk)
        versionCode(ViewModelBuildModule.versionCode)
        versionName(ViewModelBuildModule.versionName)

        testInstrumentationRunner = ViewModelBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = ViewModelBuildModule.isMinifyEnabled
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ViewModelBuildModule.compileCompatibility
        targetCompatibility = ViewModelBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = ViewModelBuildModule.jvmTarget
    }
}

dependencies {
    ViewModelBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
