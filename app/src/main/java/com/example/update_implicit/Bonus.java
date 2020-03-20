package com.example.update_implicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;

//import android.widget.Toast;
//import com.google.android.gms.actions.NoteIntents;
//    implementation 'com.google.android.gms:play-services:12.0.1'
//    implementation 'com.android.support:multidex:1.0.3'

public class Bonus extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        setTitle("Bonus");
    }

    public void createAlarm(View view) {
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Implicit Alarm");
        i.putExtra(AlarmClock.EXTRA_HOUR, 20);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 20);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void contact(View view) {
        Intent i = new Intent(Intent.ACTION_INSERT);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        i.putExtra(ContactsContract.Intents.Insert.NAME, "Intent Contact");
        ;
        i.putExtra(ContactsContract.Intents.Insert.PHONE, "08123456789");
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void call(View view) {
        if (ActivityCompat.checkSelfPermission(Bonus.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Bonus.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:082244103410"));
            startActivity(callIntent);
        }
    }

    public void notes(View view) {
//        Intent i = new Intent(NoteIntents.ACTION_CREATE_NOTE)
//                .putExtra(NoteIntents.EXTRA_NAME, "Implicit Notes")
//                .putExtra(NoteIntents.EXTRA_TEXT, "Create Notes");
//            if (i.resolveActivity(getPackageManager()) != null) {
//                startActivity(i);
//            }else {
//                Toast.makeText(this, "No App Available", Toast.LENGTH_SHORT).show();
//            }

        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
