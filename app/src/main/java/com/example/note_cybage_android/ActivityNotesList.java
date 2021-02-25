package com.example.note_cybage_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class ActivityNotesList extends AppCompatActivity {

    RecyclerView rv_notes_list;
    DatabaseHandler db;
    ArrayList<NotesData> listData=new ArrayList<>();
    ImageView btn_add_notes,btn_sort;
    AdapterNotes adapterNotes;
    EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        rv_notes_list=findViewById(R.id.rv_notes_list);
        btn_add_notes=findViewById(R.id.btn_add_notes);
        btn_sort=findViewById(R.id.btn_sort);
        et_search=findViewById(R.id.et_search);

        db=new DatabaseHandler(this);
        initView();


    }
}