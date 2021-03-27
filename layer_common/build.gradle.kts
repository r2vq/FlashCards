plugins {
    CommonBuildModule.plugins.forEach { plugin -> id(plugin) }
    CommonBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(CommonBuildModule.compileSdk)
    buildToolsVersion(CommonBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(CommonBuildModule.minSdk)
        targetSdkVersion(CommonBuildModule.targetSdk)
        versionCode(CommonBuildModule.versionCode)
        versionName(CommonBuildModule.versionName)

        testInstrumentationRunner = CommonBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = CommonBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = CommonBuildModule.compileCompatibility
        targetCompatibility = CommonBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = CommonBuildModule.jvmTarget
    }
}

dependencies {
    CommonBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
