package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra name";
    public static final String EXTRA_DETAIL = "extra detail";
    public static final String EXTRA_PHOTO = "extra photo";
    public static final String EXTRA_LINK = "link bio";

    private TextView names, details;
    private ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        names = findViewById(R.id.tv_names);
        details = findViewById(R.id.tv_details);
        images = findViewById(R.id.img_photo);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        final String linkBio = getIntent().getStringExtra(EXTRA_LINK);
        int photo = getIntent().getIntExtra(EXTRA_PHOTO, 0);

        names.setText(name);
        details.setText(detail);
        Glide.with(this).load(photo).into(images);

        images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkBio));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.com");
                try {
                    getApplicationContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    intent.setPackage(null);
                    getApplicationContext().startActivity(intent);
                }
            }
        });
    }
}
