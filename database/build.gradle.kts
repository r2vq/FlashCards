plugins {
    DatabaseBuildModule.plugins.forEach { plugin -> id(plugin) }
    DatabaseBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(DatabaseBuildModule.compileSdk)
    buildToolsVersion(DatabaseBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(DatabaseBuildModule.minSdk)
        targetSdkVersion(DatabaseBuildModule.targetSdk)
        versionCode(DatabaseBuildModule.versionCode)
        versionName(DatabaseBuildModule.versionName)

        testInstrumentationRunner = DatabaseBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = DatabaseBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = DatabaseBuildModule.compileCompatibility
        targetCompatibility = DatabaseBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = DatabaseBuildModule.jvmTarget
    }
}

dependencies {
    DatabaseBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
