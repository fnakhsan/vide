plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
    alias(libs.plugins.android.secrets.gradle)
}

android {
    namespace = "dev.ppl.vide"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.ppl.vide"
        minSdk = 24
        targetSdk = 35
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
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    //    AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)

    //    Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //    Logging
    implementation(libs.bundles.logging)

    //    DI
    implementation(libs.bundles.koin)
    ksp(libs.koin.ksp.compiler)

    //    Coroutine
    implementation(libs.bundles.coroutine)

    //    Lifecycle
    implementation(libs.bundles.lifecycle)

    //    Navigation
    implementation(libs.bundles.navigation)

    //    Serialization
    implementation(libs.kotlinx.serialization.json)

    //    Network
    implementation(libs.bundles.network)

    //    Pagination
    implementation(libs.androidx.paging.runtime)

    //    Presentation
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.recyclerview)
    implementation(libs.glide)
    ksp(libs.glide.ksp)
}

secrets {
    // Optionally specify a different file name containing your secrets.
    // The plugin defaults to "local.properties"
    propertiesFileName = "local.properties"

    // A properties file containing default secret values. This file can be
    // checked in version control.
    defaultPropertiesFileName = "local.defaults.properties"

    // Configure which keys should be ignored by the plugin by providing regular expressions.
    // "sdk.dir" is ignored by default.
    ignoreList.add("sdk.*")       // Ignore all keys matching the regexp "sdk.*"
}
