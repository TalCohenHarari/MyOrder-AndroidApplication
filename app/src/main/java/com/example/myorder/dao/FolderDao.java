package com.example.myorder.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myorder.entities.Folder;
import com.example.myorder.entities.Note;

import java.util.List;

@Dao
public interface FolderDao {
    @Query("select * from folders ORDER BY id DESC")
    List<Folder> getAllFolders();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFolder(Folder folder);

    @Delete
    void deleteFolder(Folder folder);
}
