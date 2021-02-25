package com.example.note_cybage_android.example;

import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notesApp";
    private static final String TABLE_CATEGORY = "category";
    private static final String TABLE_NOTES = "notes";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    //Notes tables name
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE_PATH = "image";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LNG = "lng";
    private static final String KEY_VOICE_PATH = "voice_path";
    private static final String KEY_CAT_ID = "cat_id";
    private static final String KEY_TIME_STAMP = "time";


}
