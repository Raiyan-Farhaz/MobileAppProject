package com.example.myuniclubs.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    // --------------------------------------------------------
    //  REGISTER USER (Name + Email stored in Firestore)
    // --------------------------------------------------------
    suspend fun registerWithName(name: String, email: String, password: String): Result<Unit> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid ?: return Result.failure(Exception("User ID null"))

            val userData = mapOf(
                "name" to name,
                "email" to email
            )

            db.collection("users")
                .document(userId)
                .set(userData)
                .await()

            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --------------------------------------------------------
    //  LOGIN USER
    // --------------------------------------------------------
    suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // --------------------------------------------------------
    //  FETCH USER NAME FROM FIRESTORE
    // --------------------------------------------------------
    suspend fun getUserName(uid: String): String? {
        return try {
            val snapshot = db.collection("users")
                .document(uid)
                .get()
                .await()

            snapshot.getString("name")

        } catch (e: Exception) {
            null
        }
    }

    // --------------------------------------------------------
    // CHECK LOGGED-IN STATE
    // --------------------------------------------------------
    fun isLoggedIn(): Boolean = auth.currentUser != null
}
