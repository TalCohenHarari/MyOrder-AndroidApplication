package com.example.myorder.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "date_time")
    private String dateTime;

    @ColumnInfo(name = "subtitle")
    private String subtitle;

    @ColumnInfo(name = "note_text")
    private String noteText;

    @ColumnInfo(name = "image_path")
    private String imagePath;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "web_link")
    private String webLink;

    @ColumnInfo(name = "folder_owner")
    private String folderOwner;


    //Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public String getDateTime() { return dateTime; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setNoteText(String noteText) { this.noteText = noteText; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setColor(String color) { this.color = color; }
    public void setWebLink(String webLink) { this.webLink = webLink; }
    public void setFolderOwner(String folderOwner) { this.folderOwner = folderOwner; }

    //Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public String getSubtitle() { return subtitle; }
    public String getNoteText() { return noteText; }
    public String getImagePath() { return imagePath; }
    public String getColor() { return color; }
    public String getWebLink() { return webLink; }
    public String getFolderOwner() { return folderOwner; }

    //Methods
    @NonNull
    @Override
    public String toString() {
        return title + " : " + dateTime;
    }
}
