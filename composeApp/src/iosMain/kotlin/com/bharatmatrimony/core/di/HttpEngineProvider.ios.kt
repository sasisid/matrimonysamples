package com.bharatmatrimony.core.di

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual fun provideHttpClientEngine(): HttpClientEngineFactory<*> = Darwin