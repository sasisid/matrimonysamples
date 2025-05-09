package com.bharatmatrimony.core.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

suspend fun initKoin(
    additionalModules: List<Module> = emptyList(),
    appDeclaration: KoinAppDeclaration = {}
) {

    startKoin {
        appDeclaration()
        modules(additionalModules + appModule + networkModule + ViewModelModule )
    }
}
