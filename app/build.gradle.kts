import org.jetbrains.kotlin.ir.backend.js.compile

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.9/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Kotlinのコンパイルを行うためのプラグイン
    alias(libs.plugins.jvm)

    // JavaのCLIアプリケーションをビルドするためのプラグイン
    // gradlw tasks で使えるコマンドを確認できる
    application

    // GradleプロジェクトをMavenリポジトリに公開するためのプラグイン
    id("maven-publish")
}

// Mavenリポジトリに公開するための設定
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.gradle.tutorial"
            artifactId = "tutorial"
            version = "1.0"

            from(components["java"])
        }
    }
}

// ライブラリの取得先のリポジトリを設定
repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

// 依存性の定義
// アプリのビルドに必要なライブラリを定義する
// ここに記載されたものが、ビルド時にインターネット上のリポジトリからダウンロードされる
dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// タスクの定義
tasks.register("hello") {
    doFirst {
        println("Hello!")
    }
    doLast {
        println("How are you?")
    }
}

// 依存関係をもったタスクの定義も可能
tasks.register("response") {
    dependsOn("hello")
    doFirst {
        println("I'm fine, thank you.")
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.AppKt"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}


