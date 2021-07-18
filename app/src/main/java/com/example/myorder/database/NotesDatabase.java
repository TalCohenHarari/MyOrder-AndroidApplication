package com.example.myorder.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myorder.dao.FolderDao;
import com.example.myorder.dao.NoteDao;
import com.example.myorder.entities.Folder;
import com.example.myorder.entities.Note;


@Database(entities = {Note.class, Folder.class}, version = 2)
public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase notesDatabase;
    public abstract NoteDao noteDao();
    public abstract FolderDao folderDao();

    public static synchronized NotesDatabase getNotesDatabase(Context context){
        if(notesDatabase==null){
            notesDatabase = Room.databaseBuilder(
                    context,
                    NotesDatabase.class,
                    "notes_db"
            ).fallbackToDestructiveMigration().build();
        }
        return notesDatabase;
    }


}

