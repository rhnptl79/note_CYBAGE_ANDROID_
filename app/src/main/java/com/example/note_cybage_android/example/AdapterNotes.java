package com.example.note_cybage_android.example;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

    @NonNull
    @Override
    public AdapterNotes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.adapter_notes_list, parent, false);

        return new AdapterNotes.MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes.MyViewHolder holder, int position) {
        holder.tv_name.setText(_list.get(position).getTitle());
        holder.tv_date.setText(_list.get(position).getTimeStamp());

        holder.rl_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context, ActivityAddNote.class);
                intent.putExtra("edit", _list.get(position));
                intent.putExtra("catId", String.valueOf(_list.get(position).getCatId()));
                _context.startActivity(intent);
            }
        });


}
