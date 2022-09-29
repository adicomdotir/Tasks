package com.example.tasks.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tasks.model.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Insert
    fun insertAll(tasks: List<Task>)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    fun get(taskId: Long): LiveData<Task>

    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<Task>>
}