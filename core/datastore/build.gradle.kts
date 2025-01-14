plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = libs.versions.appCoreNameSpace.get() + ".datastore"
    compileSdk = libs.versions.appCompileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.appMinSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    testOptions.unitTests {
        isReturnDefaultValues = true
        isIncludeAndroidResources = true
    }
}

dependencies {

    implementation(project(":core:common"))

    api(libs.androidx.dataStore.core)
    api(libs.androidx.dataStore)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.ext)
    testImplementation(libs.robolectric)
    testImplementation(libs.mockk)
    testImplementation(libs.truth)
    testImplementation(libs.turbine)
    testImplementation(libs.kotlin.test)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}