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
    namespace = "com.checky.fstory"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.checky.fstory"
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

    implementation(libs.glide)

//firebase
    implementation(libs.firebase.firestore)

//COURUTINES
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.navigation3.ui)


//HILT
    ksp(libs.hilt.compiler)
   implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)


//Livedata
    implementation(libs.androidx.lifecycle.livedata.ktx)

//core kotlin
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.material3)

//Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation3.runtime)

//Testing

    implementation(libs.androidx.ui.test)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}