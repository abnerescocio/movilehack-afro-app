package com.movilehackafro.app.objects

import com.movilehackafro.data.repositories.AreaRepositoryImpl
import com.movilehackafro.data.repositories.ContentRepositoryImpl
import com.movilehackafro.data.repositories.DisciplineRepositoryImpl
import com.movilehackafro.data.services.CommonService
import com.movilehackafro.data.services.SchoolService
import com.movilehackafro.domain.repositories.AreaRepository
import com.movilehackafro.domain.repositories.ContentRepository
import com.movilehackafro.domain.repositories.DisciplineRepository
import org.koin.dsl.module
import retrofit2.Retrofit

object KoinModules {

    private val services = module {
        single { get<Retrofit>().create(CommonService::class.java) }
        single { get<Retrofit>().create(SchoolService::class.java) }
    }

    private val repositories = module {
        single { AreaRepositoryImpl(get()) as AreaRepository }
        single { ContentRepositoryImpl(get()) as ContentRepository }
        single { DisciplineRepositoryImpl(get()) as DisciplineRepository }
    }


    val all = services + repositories
}