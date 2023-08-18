plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.khantnyar.recyclerview"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.khantnyar.recyclerview"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "ODOO_SERVER", "\"https://odoo-stg.linklusion.co.jp/\"")
        buildConfigField("String", "ODOO_API_KEY", "\"AKK3FNOAA9TDXO7PM2EF9VNKGWOICVS5\"")
    }
    buildFeatures {
        dataBinding = true
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

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:databinding-runtime:8.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //model serialization
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    //Retrofit Dependency
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.8.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0")

    //to image display
    implementation ("com.github.bumptech.glide:glide:4.15.1")
}