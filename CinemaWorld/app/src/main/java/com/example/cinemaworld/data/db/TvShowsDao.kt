package com.example.cinemaworld.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemaworld.data.model.tvShow.TvShow

@Dao
interface TvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TvShow>
}