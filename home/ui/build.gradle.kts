plugins {
    alias(notation = libs.plugins.android.library)
    alias(notation = libs.plugins.kotlin.android)
    alias(notation = libs.plugins.kotlin.serialization)
    alias(notation = libs.plugins.kotlin.compose)
}

android {
    namespace = "emmanuelmuturia.home.ui"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles(
            proguardFiles =
                arrayOf(
                    "consumer-rules.pro",
                ),
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                files =
                    arrayOf(
                        getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                        "proguard-rules.pro",
                    ),
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
        compose = true
    }
}

dependencies {

    implementation(dependencyNotation = project(path = ":commons"))
    implementation(dependencyNotation = project(path = ":home:data"))

    implementation(dependencyNotation = libs.androidx.core.ktx)
    implementation(dependencyNotation = libs.androidx.lifecycle.runtime.ktx)
    implementation(dependencyNotation = libs.androidx.activity.compose)
    implementation(dependencyNotation = platform(libs.androidx.compose.bom))
    implementation(dependencyNotation = libs.androidx.ui)
    implementation(dependencyNotation = libs.androidx.ui.graphics)
    implementation(dependencyNotation = libs.androidx.ui.tooling.preview)
    implementation(dependencyNotation = libs.androidx.material3)
    implementation(dependencyNotation = libs.bundles.compose)
    implementation(dependencyNotation = libs.bundles.koin)
    implementation(dependencyNotation = libs.coil.compose)
    implementation(dependencyNotation = libs.timber)

    testImplementation(dependencyNotation = libs.junit)
    testImplementation(dependencyNotation = libs.bundles.test)

    androidTestImplementation(dependencyNotation = libs.androidx.junit)
    androidTestImplementation(dependencyNotation = libs.androidx.espresso.core)
    androidTestImplementation(dependencyNotation = platform(libs.androidx.compose.bom))
    androidTestImplementation(dependencyNotation = libs.androidx.ui.test.junit4)

    debugImplementation(dependencyNotation = libs.androidx.ui.tooling)
    debugImplementation(dependencyNotation = libs.androidx.ui.test.manifest)
}