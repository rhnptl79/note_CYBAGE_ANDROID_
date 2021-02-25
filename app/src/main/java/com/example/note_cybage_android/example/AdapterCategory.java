package com.example.note_cybage_android.example;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder>  {

    Context _context;
    ArrayList<CategoryData> _list;
    boolean _status;
    NotesData _notesData;
    DatabaseHandler _db;
    onCatDelete listener;
    public AdapterCategory(Context context, ArrayList<CategoryData> list, boolean status, NotesData notesData, DatabaseHandler db,onCatDelete listener) {
        this._context = context;
        this._list = list;
        this._status = status;
        this._notesData = notesData;
        this._db = db;
        this.listener=listener;
    }




}
