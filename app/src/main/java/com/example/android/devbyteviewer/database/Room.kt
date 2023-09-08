/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.devbyteviewer.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VideoDao {
    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>> // LiveData makes Room run the query in the background thread and watches any data changes in the table

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // vararg - "variable arguments" is how a function can take an unknown number of args in kotlin (without using a List)
    fun insertAll(vararg videos: DatabaseVideo)
}