plugins {
    DIBuildModule.plugins.forEach { plugin -> id(plugin) }
    DIBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(DIBuildModule.compileSdk)
    buildToolsVersion(DIBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(DIBuildModule.minSdk)
        targetSdkVersion(DIBuildModule.targetSdk)
        versionCode(DIBuildModule.versionCode)
        versionName(DIBuildModule.versionName)

        testInstrumentationRunner = DIBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = DIBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = DIBuildModule.compileCompatibility
        targetCompatibility = DIBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = DIBuildModule.jvmTarget
    }
}

dependencies {
    DIBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
