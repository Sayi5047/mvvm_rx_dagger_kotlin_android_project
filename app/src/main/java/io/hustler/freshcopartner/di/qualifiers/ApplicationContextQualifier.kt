package io.hustler.freshcopartner.di.qualifiers
import javax.inject.Qualifier

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContextQualifier

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class ActivityContextQualifier