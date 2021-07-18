package com.example.myorder.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "folders")
public class Folder implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "folder_owner")
    private String folderOwner;


    //Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFolderOwner(String folderOwner) { this.folderOwner = folderOwner; }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getFolderOwner() { return folderOwner; }

}
