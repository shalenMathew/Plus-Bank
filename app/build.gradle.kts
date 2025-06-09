import com.android.build.api.dsl.Lint
import com.android.build.api.dsl.LintOptions

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("org.sonarqube") version "3.3"
}

android {
    namespace = "com.example.bankinguiapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bankinguiapp"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


    fun Lint.() {
        abortOnError = false // Don't fail build on errors
        warningsAsErrors = false // Let warnings be warnings
        checkReleaseBuilds=false // Optional: skip lint on release builds
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // system UI Controller
    implementation(libs.accompanist.systemuicontroller)

    // Extended Icons
    implementation(libs.androidx.material.icons.extended)


    implementation (libs.androidx.media3.exoplayer.v110)
    implementation (libs.androidx.media3.exoplayer.dash)
    implementation (libs.androidx.media3.ui)

    implementation (libs.androidx.navigation.compose)


    implementation (libs.androidx.constraintlayout)
    implementation (libs.androidx.constraintlayout.compose)
    testImplementation(kotlin("test"))
}