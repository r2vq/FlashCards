plugins {
    AppModule.plugins.forEach { plugin -> id(plugin) }
    AppModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(AppModule.compileSdk)
    buildToolsVersion(AppModule.buildTools)

    defaultConfig {
        applicationId = "com.keanequibilan.flashcards"
        minSdkVersion(AppModule.minSdk)
        targetSdkVersion(AppModule.targetSdk)
        versionCode(AppModule.versionCode)
        versionName(AppModule.versionName)

        testInstrumentationRunner = AppModule.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = AppModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppModule.compileCompatibility
        targetCompatibility = AppModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = AppModule.jvmTarget
    }
}

dependencies {
    AppModule.run {
        implementations.forEach { lib -> add("implementation", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
