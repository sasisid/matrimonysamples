package com.bharatmatrimony.core.di

import io.ktor.client.engine.*

expect fun provideHttpClientEngine(): HttpClientEngineFactory<*>