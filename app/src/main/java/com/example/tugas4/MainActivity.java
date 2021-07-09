package com.example.tugas4;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {
    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.edtPhoneNumber);
        websiteUri = findViewById(R.id.edtWebsiteUri);
        locationUri = findViewById(R.id.edtLocationUri);
        textShare = findViewById(R.id.edtShareText);
    }

    public void openDialPhone(View view) {
        if (phoneNumber.getText().toString() == null || phoneNumber.getText().toString().trim().equals("")) {
            Toast.makeText(getBaseContext(), "Jangan Kosong Dong", Toast.LENGTH_LONG).show();
        } else {
            Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + phoneNumber.getText().toString()));
            startActivity(dialPhone);
        }
    }

    public void openBrowser(View view) {
        if (websiteUri.getText().toString() == null || websiteUri.getText().toString().trim().equals("")) {
            Toast.makeText(getBaseContext(), "Jangan Kosong Dong", Toast.LENGTH_LONG).show();
        } else {
            String url = websiteUri.getText().toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
                Intent openWebsite = new
                        Intent(Intent.ACTION_VIEW, Uri.parse
                        (url));
                startActivity(openWebsite);
            }

        }
    }

    public void openShareText(View view) {
        if (textShare.getText().toString() == null || textShare.getText().toString().trim().equals("")) {
            Toast.makeText(getBaseContext(), "Jangan Kosong Dong", Toast.LENGTH_LONG).show();
        } else {
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType("text/plan")
                    .setChooserTitle("Share this text with : "
                    )
                    .setText(textShare.getText().toString())
                    .startChooser();
        }
    }

    public void openLocation(View view) {
        if (locationUri.getText().toString() == null || locationUri.getText().toString().trim().equals("")) {
            Toast.makeText(getBaseContext(), "Jangan Kosong Dong", Toast.LENGTH_LONG).show();
        } else {
            Intent openLocation = new
                    Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" +
                    locationUri.getText().toString()));
            startActivity(openLocation);
        }
    }
}