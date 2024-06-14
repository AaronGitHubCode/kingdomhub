plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "app.kh"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.kh"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    ndkVersion = "27.0.11902837"

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
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.badlogicgames.gdx-controllers:gdx-controllers-core:2.0.1")
    implementation("com.badlogicgames.gdx-controllers:gdx-controllers-android:2.0.1")
    implementation("com.badlogicgames.gdx:gdx:1.12.1")
    implementation("pl.mk5.gdx-fireapp:gdx-fireapp-core:3.3.1")
    implementation("pl.mk5.gdx-fireapp:gdx-fireapp-android:3.3.1")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.core.ktx)
    runtimeOnly("com.airbnb.android:lottie:6.4.1")
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}