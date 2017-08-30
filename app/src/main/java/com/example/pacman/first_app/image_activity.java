package com.example.pacman.first_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class image_activity extends AppCompatActivity {

   Button b1,b2,b3;
    EditText ed1,ed2;
    ImageView i1;
    //Creation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_activity);
        init();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,200);




            }



        });


       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_CALL);
               intent.setData(Uri.parse("tel:"+ed1.getText().toString()));
               if (ActivityCompat.checkSelfPermission(image_activity.this, Manifest.permission.CALL_PHONE) !=
               PackageManager.PERMISSION_GRANTED) {
                   return;
               }

               startActivity(intent);
           }
       });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if(requestCode==200 && resultCode==RESULT_OK&& data !=null){
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            i1.setImageBitmap(bitmap);


        }
    }

    private void init()
    {
        //Declaration
         b1=(Button) findViewById(R.id.button2);
         b2=(Button) findViewById(R.id.button3);
         b3=(Button) findViewById(R.id.button4);
         i1=(ImageView) findViewById(R.id.imageView2);
         ed1=(EditText) findViewById(R.id.editText);
         ed2=(EditText) findViewById(R.id.editText2);

    }
}
