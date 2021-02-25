package com.example.note_cybage_android;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAddNote extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    DatabaseHandler db;
    ImageView add_image;
    EditText et_title, et_decription;
    String latitude, longitude, image_path,voice_path;
    TextView btnSave, location;
    Button btn_rm_pic;
    ChoosePhotoHelper choosePhotoHelper;
    LocationManager locationManager;
    NotesData notesData;

    private MediaPlayer player;

    private Button startRecordingButton, stopRecordingButton,btnPlayRecording;

    private MediaRecorder recorder;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        add_image = findViewById(R.id.add_image);
        et_title = findViewById(R.id.et_title);
        et_decription = findViewById(R.id.et_decription);
        btnSave = findViewById(R.id.btn_save);
        location = findViewById(R.id.location);
        startRecordingButton = findViewById(R.id.startRecordingButton);
        btnPlayRecording = findViewById(R.id.btnPlayRecording);
        stopRecordingButton = findViewById(R.id.stopRecordingButton);
        btn_rm_pic = findViewById(R.id.btn_rm_pic);
        image_path = "";
        voice_path = "";
        latitude = "";
        longitude = "";
        db=new DatabaseHandler(this);
    }
}