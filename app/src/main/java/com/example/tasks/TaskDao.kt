package com.example.tasks

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Insert
    fun insertAll(tasks: List<Task>)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    fun get(taskId: Long): LiveData<Task>

    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<Task>>
}