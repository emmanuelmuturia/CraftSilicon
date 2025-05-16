plugins {
    alias(notation = libs.plugins.android.library)
    alias(notation = libs.plugins.kotlin.android)
    alias(notation = libs.plugins.ksp)
    alias(notation = libs.plugins.kotlin.serialization)
    alias(notation = libs.plugins.secrets.gradle)
}

android {
    namespace = "emmanuelmuturia.home.source"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles(
            proguardFiles = arrayOf(
                "consumer-rules.pro"
            )
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                files = arrayOf(
                    getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }

        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(dependencyNotation = libs.room.runtime)
    implementation(dependencyNotation = libs.room.ktx)
    ksp(dependencyNotation = libs.room.compiler)

    implementation(dependencyNotation = libs.bundles.networking)
    implementation(dependencyNotation = libs.bundles.koin)
    implementation(dependencyNotation = libs.timber)

    implementation(dependencyNotation = libs.androidx.core.ktx)
    implementation(dependencyNotation = libs.androidx.appcompat)
    implementation(dependencyNotation = libs.material)
    testImplementation(dependencyNotation = libs.junit)

    androidTestImplementation(dependencyNotation = libs.bundles.test)
    androidTestImplementation(dependencyNotation = libs.androidx.junit)
    androidTestImplementation(dependencyNotation = libs.androidx.espresso.core)
}