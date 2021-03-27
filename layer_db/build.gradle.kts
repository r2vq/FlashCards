plugins {
    LayerDbBuildModule.plugins.forEach { plugin -> id(plugin) }
    LayerDbBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

val buildModule = LayerDbBuildModule
android {
    compileSdkVersion(buildModule.compileSdk)
    buildToolsVersion(buildModule.buildTools)

    defaultConfig {
        minSdkVersion(buildModule.minSdk)
        targetSdkVersion(buildModule.targetSdk)
        versionCode(buildModule.versionCode)
        versionName(buildModule.versionName)

        testInstrumentationRunner = buildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = buildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = buildModule.compileCompatibility
        targetCompatibility = buildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = buildModule.jvmTarget
    }
}

dependencies {
    buildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
