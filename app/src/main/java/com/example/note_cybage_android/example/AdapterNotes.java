package com.example.note_cybage_android.example;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.MyViewHolder> {

    Context _context;
    ArrayList<NotesData> _list;
    DatabaseHandler _db;

    public AdapterNotes(Context _context, ArrayList<NotesData> _list, DatabaseHandler db) {
        this._context = _context;
        this._list = _list;
        this._db = db;
    }


}
