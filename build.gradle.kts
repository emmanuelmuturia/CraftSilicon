// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(notation = libs.plugins.android.application) apply false
    alias(notation = libs.plugins.kotlin.android) apply false
    alias(notation = libs.plugins.android.library) apply false
    alias(notation = libs.plugins.kotlin.compose) apply false
    alias(notation = libs.plugins.ksp) apply false
    alias(notation = libs.plugins.kotlin.serialization) apply false
    alias(notation = libs.plugins.ktlint)
    alias(notation = libs.plugins.detekt)
    alias(notation = libs.plugins.spotless)
}