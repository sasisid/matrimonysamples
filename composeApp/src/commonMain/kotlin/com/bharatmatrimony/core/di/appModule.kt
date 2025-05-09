package com.bharatmatrimony.core.di

import com.bharatmatrimony.core.prefs.AppPreferences
import com.bharatmatrimony.core.prefs.AppPreferencesImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    single<CoroutineDispatcher> { Dispatchers.Default }

    single { AppPreferencesImpl(get()) as AppPreferences }


}