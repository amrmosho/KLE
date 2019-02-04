package com.example.empcl.kle;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.empcl.kle.lib.MyActivity;

import java.util.Random;

public class NumbersActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        images[0] =findViewById(R.id.image_1);
        images[1] =findViewById(R.id.image_2);
        images[2] =findViewById(R.id.image_3);
        images[3] =findViewById(R.id.image_4);
        images[4] =findViewById(R.id.image_5);
        images[5] =findViewById(R.id.image_6);
        images[6] =findViewById(R.id.image_7);
        images[7] =findViewById(R.id.image_8);
        images[8] =findViewById(R.id.image_9);
        images[9] =findViewById(R.id.image_10);




        txt_item = findViewById(R.id.txt_item);

        reloadbck = findViewById(R.id.reloadbck);
        bcktohomebtn = findViewById(R.id.bcktohomebtn);

        reloadbck.setVisibility(View.GONE);
        bcktohomebtn.setVisibility(View.GONE);

        update_data();

    }


    ImageView reloadbck,bcktohomebtn;

TextView  txt_item ;


    int index = 0 ;


    public void next(View view) {
        index++;
        if (index >= (text.length)) {
            index--;
            reloadbck.setVisibility(View.VISIBLE);
            bcktohomebtn.setVisibility(View.VISIBLE);

            //   images_index = 0;
        }else{



            update_data();

        }



    }



    public void prev(View view) {
        index--;
        if (index < 0) {
            index = (images.length - 1);
        }

        update_data();


    }

    MediaPlayer mp;

    void update_data() {


        if (mp !=null){
            mp.stop();
        }


for ( ImageView img : images){
    img.setVisibility(View.GONE);


}        int idxt = new Random().nextInt(closeAnimation.length);

        txt_item.setText(text[index]);

        Animation ot = AnimationUtils.loadAnimation(this, openAnimation[idxt]);

        txt_item.startAnimation(ot);




            int idx = new Random().nextInt(closeAnimation.length);


         mp = MediaPlayer.create(this, sound[index]);

        mp.start();




        Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
        int idxi = new Random().nextInt(setImages.length);



        for ( int i = 0 ; i<= index ; i++){
            images[i].setVisibility(View.VISIBLE);

            images[i].setImageResource(setImages[idxi]);

         images[i].startAnimation(o);



        }


    }



    ImageView images[]= new ImageView[10];

    String[] text = {


            "1", "2", "3" , "4", "5", "6" , "7", "8", "9" , "10"


    };
    int[] setImages = {


            R.drawable.animals_img_1, R.drawable.animals_img_2, R.drawable.animals_img_3,R.drawable.fruits_lem_img, R.drawable.fruits_lem_img, R.drawable.fruits_apple_img, R.drawable.fruits_lem_img



    };



    int[] sound= { R.raw.sound_numbers_1,
            R.raw.sound_numbers_2,  R.raw.sound_numbers_3, R.raw.sound_numbers_4,R.raw.sound_numbers_5, R.raw.sound_numbers_6,
            R.raw.sound_numbers_7, R.raw.sound_numbers_8, R.raw.sound_numbers_9, R.raw.sound_numbers_10



    };


}
