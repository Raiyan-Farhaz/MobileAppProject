package com.example.myuniclubs.data

class ClubRepository(private val dao: ClubDao) {

    suspend fun insertClub(club: ClubEntity) {
        dao.insertClub(club)
    }

    suspend fun deleteClub(club: ClubEntity) {
        dao.deleteClub(club)
    }

    suspend fun getAllClubs(): List<ClubEntity> {
        return dao.getAllClubs()
    }

    suspend fun updateSavedStatus(clubId: Int, isSaved: Boolean) {
        dao.updateSavedStatus(clubId, isSaved)
    }
}

