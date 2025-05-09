import com.android.build.gradle.tasks.MergeResources
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.apollo)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.cocoapods)

}



kotlin {
    jvmToolchain(11)
    androidTarget {
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
    }

    js(IR) {
        moduleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.2"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }

    }
    sourceSets {
            commonMain.dependencies {

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.kotlinLogging)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.serialization.kotlinx.json)

                implementation(libs.ktor.client.logging)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.androidx.navigation.composee)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinInject)
                implementation(libs.coil)
                implementation(libs.coil.network.ktor)
                implementation(libs.multiplatformSettings)
                implementation(libs.kotlinx.datetime)
                implementation(libs.apollo.runtime)
                implementation(libs.kstore)

                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)


            }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
            implementation(libs.kotlinx.coroutines.test)
        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.activityCompose)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)

            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.androidx.security.crypto)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
//            implementation(libs.ktor.client.js)

            implementation(npm("crypto-js", "4.2.0"))
            implementation(npm("text-encoding", "0.7.0"))
            implementation(npm("base64-js", "1.5.1")) // for key encoding
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

    }

}



android {
    namespace = "com.bharatmatrimony"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35

        applicationId = "com.bharatmatrimony.androidApp"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
    }
    signingConfigs {
        create("configBM") {}
        create("configtamilMatrimony") {}
        create("configkannadamatrimony") {}
        create("configpunjabimatrimony") {}
        create("configbengalimatrimony") {}
        create("configoriyamatrimony") {}
        create("configkeralamatrimony") {}
        create("configmarathimatrimony") {}
        create("configgujaratimatrimony") {}
        create("configtelugumatrimony") {}
        create("confighindimatrimony") {}
        create("configmarwadimatrimony") {}
        create("configurdumatrimony") {}
        create("configassamesematrimony") {}
        create("configsindhimatrimony") {}
        create("configbiharimatrimony") {}
        create("configrajasthanimatrimony") {}
        create("configbhojpurimatrimony") {}
    }

    flavorDimensions += "product"

    productFlavors {
        create("bharatmatrimony") {
            dimension = "product"
            applicationId = "com.bharatmatrimony"
            buildConfigField("int", "appType", "104")
            signingConfig = signingConfigs.getByName("configBM")
        }
        create("tamilmatrimony") {
            dimension = "product"
            applicationId = "com.tamilmatrimony"
            buildConfigField("int", "appType", "131")
            signingConfig = signingConfigs.getByName("configtamilMatrimony")
        }
        create("kannadamatrimony") {
            dimension = "product"
            applicationId = "com.kannadamatrimony"
            buildConfigField("int", "appType", "136")
            signingConfig = signingConfigs.getByName("configkannadamatrimony")
        }
        create("punjabimatrimony") {
            dimension = "product"
            applicationId = "com.punjabimatrimony"
            buildConfigField("int", "appType", "139")
            signingConfig = signingConfigs.getByName("configpunjabimatrimony")
        }
        create("bengalimatrimony") {
            dimension = "product"
            applicationId = "com.bengalimatrimony"
            buildConfigField("int", "appType", "133")
            signingConfig = signingConfigs.getByName("configbengalimatrimony")
        }
        create("oriyamatrimony") {
            dimension = "product"
            applicationId = "com.oriyamatrimony"
            buildConfigField("int", "appType", "137")
            signingConfig = signingConfigs.getByName("configoriyamatrimony")
        }
        create("keralamatrimony") {
            dimension = "product"
            applicationId = "com.keralamatrimony"
            buildConfigField("int", "appType", "132")
            signingConfig = signingConfigs.getByName("configkeralamatrimony")
        }
        create("marathimatrimony") {
            dimension = "product"
            applicationId = "com.marathimatrimony"
            buildConfigField("int", "appType", "135")
            signingConfig = signingConfigs.getByName("configmarathimatrimony")
        }
        create("gujaratimatrimony") {
            dimension = "product"
            applicationId = "com.gujaratimatrimony"
            buildConfigField("int", "appType", "138")
            signingConfig = signingConfigs.getByName("configgujaratimatrimony")
        }
        create("telugumatrimony") {
            dimension = "product"
            applicationId = "com.telugumatrimony"
            buildConfigField("int", "appType", "134")
            signingConfig = signingConfigs.getByName("configtelugumatrimony")
        }
        create("hindimatrimony") {
            dimension = "product"
            applicationId = "com.hindimatrimony"
            buildConfigField("int", "appType", "140")
            signingConfig = signingConfigs.getByName("confighindimatrimony")
        }
        create("marwadimatrimony") {
            dimension = "product"
            applicationId = "com.marwadimatrimony"
            buildConfigField("int", "appType", "141")
            signingConfig = signingConfigs.getByName("configmarwadimatrimony")
        }
        create("urdumatrimony") {
            dimension = "product"
            applicationId = "com.urdumatrimony"
            buildConfigField("int", "appType", "142")
            signingConfig = signingConfigs.getByName("configurdumatrimony")
        }
        create("assamesematrimony") {
            dimension = "product"
            applicationId = "com.assamesematrimony"
            buildConfigField("int", "appType", "143")
            signingConfig = signingConfigs.getByName("configassamesematrimony")
        }
        create("sindhimatrimony") {
            dimension = "product"
            applicationId = "com.sindhimatrimony"
            buildConfigField("int", "appType", "145")
            signingConfig = signingConfigs.getByName("configsindhimatrimony")
        }
        create("biharimatrimony") {
            dimension = "product"
            applicationId = "com.biharimatrimony"
            buildConfigField("int", "appType", "146")
            signingConfig = signingConfigs.getByName("configbiharimatrimony")
        }
        create("rajasthanimatrimony") {
            dimension = "product"
            applicationId = "com.rajasthanimatrimony"
            buildConfigField("int", "appType", "147")
            signingConfig = signingConfigs.getByName("configrajasthanimatrimony")
        }
        create("bhojpurimatrimony") {
            dimension = "product"
            applicationId = "com.bhojpurimatrimony"
            buildConfigField("int", "appType", "148")
            signingConfig = signingConfigs.getByName("configbhojpurimatrimony")
        }
    }

}

//https://developer.android.com/develop/ui/compose/testing#setup
dependencies {
    androidTestImplementation(libs.androidx.uitest.junit4)
    debugImplementation(libs.androidx.uitest.testManifest)
}

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
}

apollo {
    service("api") {
        // GraphQL configuration here.
        // https://www.apollographql.com/docs/kotlin/advanced/plugin-configuration/
        packageName.set("com.bharatmatrimony.graphql")
    }
}




