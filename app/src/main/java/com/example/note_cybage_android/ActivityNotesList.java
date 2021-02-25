package com.example.note_cybage_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        btn_add_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityNotesList.this, ActivityAddNote.class);
                intent.putExtra("catId",getIntent().getStringExtra("catId"));
                startActivity(intent);
            }
        });

        btn_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listData.sort(String::compareToIgnoreCase);
                Collections.sort(listData, new Comparator<NotesData>() {
                    @Override
                    public int compare(NotesData item, NotesData t1) {
                        String s1 = item.getTitle();
                        String s2 = t1.getTitle();
                        return s1.compareToIgnoreCase(s2);
                    }

                });
                adapterNotes.notifyDataSetChanged();
            }
        });
    }
}