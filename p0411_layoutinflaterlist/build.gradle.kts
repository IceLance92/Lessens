plugins {
    alias(libs.plugins.androidApplication)
}

android {
<<<<<<< HEAD
    namespace = "com.practicum.p0411_layoutinflaterlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.practicum.p0411_layoutinflaterlist"
=======
    namespace = "ru.startandroid.develop.p0411_layoutinflaterlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.startandroid.develop.p0411_layoutinflaterlist"
>>>>>>> 4bb4a6c (проверка совместимости с тем)
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}