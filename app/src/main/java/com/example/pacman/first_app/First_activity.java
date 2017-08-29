package com.example.pacman.first_app;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        final Button btn=(Button) findViewById(R.id.first_btn);
        btn.setTypeface(abc);

        //Vibration when  app open

        /*
        Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long a[]=new long[3];//declaration and instantiation
        a[0]=1000;//initialization
        a[1]=20;
        a[2]=2000;
        vibrator.vibrate(a,3);
        */

        //end

        //vibration when button is clicked

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                //For Vibrator
                Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(200);
                //end
                //For Playing Sound
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.button_1);
                    mediaPlayer.start();
                //end
                //For Animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hi);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(First_activity.this,second_activity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn.startAnimation(animation);



            }
        });

        //end
    }
}
