buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        ProjectConfig.dependencies.forEach { dependency ->
            classpath(dependency)
        }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
