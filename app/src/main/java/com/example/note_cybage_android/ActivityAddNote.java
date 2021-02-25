package com.example.note_cybage_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
    if (getIntent().hasExtra("edit")){
        notesData=(NotesData)getIntent().getSerializableExtra("edit");
        btnSave.setText("Update Note");
        et_decription.setText(notesData.getDescription());
        et_title.setText(notesData.getTitle());
        latitude=notesData.getLat();
        longitude=notesData.getLng();

        image_path = notesData.getImagePath();
        Glide.with(ActivityAddNote.this)
                .load(notesData.getImagePath())
                .into(add_image);
        btn_rm_pic.setVisibility(View.VISIBLE);
        location.setText("Map");

        if (!notesData.getVoicePath().toString().isEmpty()){
            voice_path = notesData.getVoicePath();
            btnPlayRecording.setVisibility(View.VISIBLE);
        }

    }
    location.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String geoUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + "locationName" + ")";
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }}
    });
    getCurrentLocation();









}


















