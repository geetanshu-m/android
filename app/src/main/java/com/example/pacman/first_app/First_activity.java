package com.example.pacman.first_app;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by PacMan on 8/29/2017.
 */

public class First_activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        AssetManager assetManager=getAssets();
        Typeface abc=Typeface.createFromAsset(assetManager,"font/Xanadu.ttf");
        Button btn=(Button) findViewById(R.id.first_btn);
        btn.setTypeface(abc);
    }
}
