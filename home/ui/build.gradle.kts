/*
 * Copyright 2025 Craft Silicon
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
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
    implementation(dependencyNotation = libs.glide)
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