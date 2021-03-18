plugins {
    RepositoryBuildModule.plugins.forEach { plugin -> id(plugin) }
    RepositoryBuildModule.kotlinPlugins.forEach { plugin -> kotlin(plugin) }
}

android {
    compileSdkVersion(RepositoryBuildModule.compileSdk)
    buildToolsVersion(RepositoryBuildModule.buildTools)

    defaultConfig {
        minSdkVersion(RepositoryBuildModule.minSdk)
        targetSdkVersion(RepositoryBuildModule.targetSdk)
        versionCode(RepositoryBuildModule.versionCode)
        versionName(RepositoryBuildModule.versionName)

        testInstrumentationRunner = RepositoryBuildModule.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = RepositoryBuildModule.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = RepositoryBuildModule.compileCompatibility
        targetCompatibility = RepositoryBuildModule.compileCompatibility
    }
    kotlinOptions {
        jvmTarget = RepositoryBuildModule.jvmTarget
    }
}

dependencies {
    RepositoryBuildModule.run {
        localModules.forEach { lib -> add("implementation", project(lib)) }
        implementations.forEach { lib -> add("implementation", lib) }
        kapts.forEach { lib -> add("kapt", lib) }
        testImplementations.forEach { lib -> add("testImplementation", lib) }
        androidTestImplementations.forEach { lib -> add("androidTestImplementation", lib) }
    }
}
