package com.example.myuniclubs.data

import androidx.room.*

@Dao
interface ClubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClub(club: ClubEntity)

    @Delete
    suspend fun deleteClub(club: ClubEntity)

    @Query("SELECT * FROM clubs")
    suspend fun getAllClubs(): List<ClubEntity>

    @Query("UPDATE clubs SET saved = :isSaved WHERE id = :clubId")
    suspend fun updateSavedStatus(clubId: Int, isSaved: Boolean)
}
