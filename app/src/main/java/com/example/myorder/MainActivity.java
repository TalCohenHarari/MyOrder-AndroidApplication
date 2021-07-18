package com.example.myorder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myorder.adapters.NotesAdapter;
import com.example.myorder.database.NotesDatabase;
import com.example.myorder.entities.Note;

import java.util.ArrayList;
import java.util.List;

//https://youtu.be/hlkekoPqsis
public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NOTE = 1;
    ImageView imageAddNoteMain;
    private RecyclerView notesRecyclerView;
    private List<Note> noteList;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize
        imageAddNoteMain = findViewById(R.id.imageAddNoteMain);

        //RecyclerView
        notesRecyclerView = findViewById(R.id.notesRycyclerview);
        notesRecyclerView.setHasFixedSize(true);
        notesRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        noteList = new ArrayList<>();
        notesAdapter = new NotesAdapter(noteList);
        notesRecyclerView.setAdapter(notesAdapter);

        //Listeners
        imageAddNoteMain.setOnClickListener(v->startActivityForResult(new Intent(getApplicationContext(),CreateNoteActivity.class),REQUEST_CODE_ADD_NOTE));


        //init
        getNotes();
    }

    private void getNotes(){

        class getNotesTask extends AsyncTask<Void, Void, List<Note>>{

            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NotesDatabase.getNotesDatabase(getApplicationContext()).noteDao().getAllNotes();
            }

            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                //If he list is empty we loading it from databse
                if(noteList.size()==0){
                    noteList.addAll(notes);
                    notesAdapter.notifyDataSetChanged();
                }
                //else we load just the last item (note)
                else{
                    noteList.add(0,notes.get(0));
                    notesAdapter.notifyItemInserted(0);
                }
                //Then we just scroll to the top our recyclerview
                notesRecyclerView.smoothScrollToPosition(0);
            }
        }

        new getNotesTask().execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_ADD_NOTE && resultCode==RESULT_OK){
            getNotes();
        }
    }
}