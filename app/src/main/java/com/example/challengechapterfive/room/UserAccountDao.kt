package com.example.challengechapterfive.room

import androidx.room.*

@Dao
interface UserAccountDao {
    @Update
    fun updateAccount(user: UserAccount): Int

    @Query("SELECT * FROM UserAccount WHERE email = :email ")
    fun login(email: String):UserAccount?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserAccount(user: UserAccount):Long
}