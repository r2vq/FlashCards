plugins {
    DatabaseModule.plugins.forEach { plugin -> id(plugin) }
    DatabaseModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(DatabaseModule.compileSdk)
    buildToolsVersion(DatabaseModule.buildTools)

    defaultConfig {
        minSdkVersion(DatabaseModule.minSdk)
        targetSdkVersion(DatabaseModule.targetSdk)
        versionCode(DatabaseModule.versionCode)
        versionName(DatabaseModule.versionName)

        testInstrumentationRunner = DatabaseModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = DatabaseModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = DatabaseModule.compileCompatibility
        targetCompatibility = DatabaseModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = DatabaseModule.jvmTarget
    }
}

dependencies {
    DatabaseModule.run {
        implementations.forEach { lib -> add("implementation", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
