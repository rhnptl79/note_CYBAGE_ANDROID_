package com.example.note_cybage_android.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";

        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"+ KEY_DESCRIPTION + " TEXT,"
                + KEY_IMAGE_PATH + " TEXT,"+ KEY_LAT + " TEXT,"+ KEY_LNG + " TEXT,"+ KEY_VOICE_PATH + " TEXT,"+
                KEY_CAT_ID + " TEXT," +KEY_TIME_STAMP  + " TEXT" + ")";



        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);

        // Create tables again
        onCreate(db);
    }

    //Add Category
    public void addCategory(CategoryData data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, data.getcName()); // Category Name

        // Inserting Row
        db.insert(TABLE_CATEGORY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection

    }

    // code to get all contacts in a list view
    public List<CategoryData> getAllCategory() {
        List<CategoryData> data = new ArrayList<CategoryData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CategoryData categoryData = new CategoryData(Integer.parseInt(cursor.getString(0)),cursor.getString(1));

                // Adding category to list
                data.add(categoryData);
            } while (cursor.moveToNext());
        }

        // return category list
        return data;
    }

    // Deleting single category
    public void deleteCategory(CategoryData data, AdapterCategory.onCatDelete listener) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CATEGORY, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getcId()) });
        db.close();
        deleteAllNotesCategory(data,listener);
    }

    public void deleteAllNotesCategory(CategoryData data, AdapterCategory.onCatDelete listener){
        ArrayList<NotesData> list=new ArrayList<>();
        list.addAll(getAllNotes(String.valueOf(data.getcId())));
        for (NotesData notesData:list){
            deleteNotes(notesData);
        }
        listener.onCatRemove();
    }
    //Add Notes
    public void addNotes(NotesData data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_TITLE, data.getTitle()); // Notes title
        values.put(KEY_DESCRIPTION, data.getDescription()); // Notes Description
        values.put(KEY_IMAGE_PATH, data.getImagePath()); // Notes imagepath
        values.put(KEY_LAT, data.getLat()); // Notes lat
        values.put(KEY_LNG, data.getLng()); // Notes lng
        values.put(KEY_VOICE_PATH, data.getVoicePath()); // Notes voice path
        values.put(KEY_CAT_ID, String.valueOf(data.getCatId())); // Notes cat id
        values.put(KEY_TIME_STAMP, GeneralFunction.getCurrentDateTime()); // Notes time stamp

        // Inserting Row
        db.insert(TABLE_NOTES, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to update the single note
    public int updateNotes(NotesData data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, data.getTitle()); // Notes title
        values.put(KEY_DESCRIPTION, data.getDescription()); // Notes Description
        values.put(KEY_IMAGE_PATH, data.getImagePath()); // Notes imagepath
        values.put(KEY_LAT, data.getLat()); // Notes lat
        values.put(KEY_LNG, data.getLng()); // Notes lng
        values.put(KEY_VOICE_PATH, data.getVoicePath()); // Notes voice path
        values.put(KEY_CAT_ID, String.valueOf(data.getCatId())); // Notes cat id
        values.put(KEY_TIME_STAMP, GeneralFunction.getCurrentDateTime()); // Notes time stamp



        // updating row
        return db.update(TABLE_NOTES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getnId()) });
    }
    // code to move the single note
    public int moveNotes(NotesData data,String catId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, data.getTitle()); // Notes title
        values.put(KEY_DESCRIPTION, data.getDescription()); // Notes Description
        values.put(KEY_IMAGE_PATH, data.getImagePath()); // Notes imagepath
        values.put(KEY_LAT, data.getLat()); // Notes lat
        values.put(KEY_LNG, data.getLng()); // Notes lng
        values.put(KEY_VOICE_PATH, data.getVoicePath()); // Notes voice path
        values.put(KEY_CAT_ID, catId); // Notes cat id
        values.put(KEY_TIME_STAMP, GeneralFunction.getCurrentDateTime()); // Notes time stamp



        // updating row
        return db.update(TABLE_NOTES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getnId()) });
    }






}




























