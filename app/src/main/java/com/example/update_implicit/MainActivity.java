package com.example.update_implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void text(View view) {
        String txt = ("Intent Implicit SMS");
        Intent txtIntent = new Intent(Intent.ACTION_SENDTO);
        txtIntent.setData(Uri.parse("smsto:082244103410"));
        txtIntent.putExtra("sms_body", txt);

        if (txtIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(txtIntent);
        }
    }

    public void dial(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:082244103410"));
        startActivity(callIntent);
    }

    public void web(View view) {
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stmik-yadika.ac.id/"));
        startActivity(website);
    }

    public void maps(View view) {
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW);
        Uri geoLocation = Uri.parse("geo:0,0?q=STMIK+Yadika+Bangil");
        mapsIntent.setData(geoLocation);

        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }
    }

    public void mail(View view) {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
        mailIntent.setData(Uri.parse("mailto:ahmadabuhasan@mhs.stmik-yadika.ac.id"));
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Implicit Mail");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Hello World!");

        if (mailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mailIntent);
        }
    }

    public void wa(View view) {
        String number = "6282244103410";
        String url = "https://api.whatsapp.com/send?phone="+number;
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        whatsapp.setData(Uri.parse(url));
        startActivity(whatsapp);
    }

    public void tentang(View view) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }

    public void  tambahan(View view) {
        Intent intent = new Intent(MainActivity.this, Bonus.class);
        startActivity(intent);
    }

}
