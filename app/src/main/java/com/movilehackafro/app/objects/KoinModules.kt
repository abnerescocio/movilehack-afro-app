package com.movilehackafro.app.objects

import androidx.room.Room
import com.movilehackafro.app.ui.discipline.set.DisciplineSetViewModel
import com.movilehackafro.app.ui.discipline.list.DisciplineListViewModel
import com.movilehackafro.app.ui.area.list.AreaListViewModel
import com.movilehackafro.app.ui.content.list.ContentListViewModel
import com.movilehackafro.app.ui.event.list.EventListViewModel
import com.movilehackafro.data.repositories.AreaRepositoryImpl
import com.movilehackafro.data.repositories.ContentRepositoryImpl
import com.movilehackafro.data.repositories.DisciplineRepositoryImpl
import com.movilehackafro.data.repositories.EventRepositoryImpl
import com.movilehackafro.data.source.local.AppDatabase
import com.movilehackafro.data.source.remote.services.CommonService
import com.movilehackafro.data.source.remote.services.SchoolService
import com.movilehackafro.domain.repositories.AreaRepository
import com.movilehackafro.domain.repositories.ContentRepository
import com.movilehackafro.domain.repositories.DisciplineRepository
import com.movilehackafro.domain.repositories.EventRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object KoinModules {

    private val viewModels = module {
        viewModel { ContentListViewModel(get()) }
        viewModel { DisciplineListViewModel(get()) }
        viewModel { DisciplineSetViewModel(get()) }
        viewModel { AreaListViewModel(get()) }
        viewModel { EventListViewModel(get()) }
    }

    private val databases = module {
        single {
            Room.databaseBuilder(
                get(),
                AppDatabase::class.java,
                "movilehack-afro-app"
            ).build()
        }

        single { get<AppDatabase>().disciplineDao() }
    }

    private val services = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://developer.android.com/training/data-storage/room/")
                .build()
        }

        single { get<Retrofit>().create(CommonService::class.java) }
        single { get<Retrofit>().create(SchoolService::class.java) }
    }

    private val repositories = module {
        single { AreaRepositoryImpl(get()) as AreaRepository }
        single { ContentRepositoryImpl(get()) as ContentRepository }
        single { DisciplineRepositoryImpl(get(), get()) as DisciplineRepository }
        single { EventRepositoryImpl(get()) as EventRepository }
    }

    val all = viewModels + databases + services + repositories

}