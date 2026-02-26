plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
//    alias(libs.plugins.ksp)
}

android {
    namespace = "com.abexa.Checky"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.Checky.FStory"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11


    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
//Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)

    //Coil
    implementation(libs.coil.compose)

//Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

//DataStore
    implementation(libs.androidx.datastore)

//retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.adapter)

//glide

    implementation("com.github.bumptech.glide:glide:4.16.0")

//firebase
    implementation(libs.firebase.firestore)

//COURUTINES
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation(libs.androidx.navigation3.ui)


//HILT
    ksp(libs.hilt.compiler)
   implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)


//Livedata

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.4")

//core kotlin
    implementation("androidx.core:core-ktx:1.17.0")

    implementation("androidx.compose.material3:material3:1.4.0")

//Navigation
    implementation(libs.androidx.navigation.compose)

//Testing
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.test)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}