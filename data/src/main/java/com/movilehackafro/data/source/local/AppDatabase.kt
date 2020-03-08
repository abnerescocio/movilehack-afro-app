package com.movilehackafro.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movilehackafro.data.source.local.daos.DisciplineDao
import com.movilehackafro.data.source.local.entities.DisciplineEntity

@Database(entities = [DisciplineEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun disciplineDao(): DisciplineDao

}