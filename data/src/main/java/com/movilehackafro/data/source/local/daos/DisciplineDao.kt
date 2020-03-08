package com.movilehackafro.data.source.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.movilehackafro.data.source.local.entities.DisciplineEntity

@Dao
interface DisciplineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun set(disciplines: List<DisciplineEntity>)

}