package com.mount.data.database

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(entity : UserEntity) : Completable

    @Query("SELECT * FROM user_table")
    fun getAllUser() : Single<List<UserEntity>>

    @Query("SELECT * FROM user_table WHERE name like '%' || :name || '%'")
    fun getAllUser(name : String) : Single<List<UserEntity>>

    @Delete
    fun deleteUser(entity: UserEntity) : Completable

    @Query("DELETE FROM user_table")
    fun deleteAllUser() : Completable
}