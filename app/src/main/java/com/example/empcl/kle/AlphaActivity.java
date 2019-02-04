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

public class AlphaActivity extends MyActivity {
    ImageView img_item;
    TextView txt_item,img_item_small;
    ImageView reloadbck,bcktohomebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);

        img_item = findViewById(R.id.img_item);
        txt_item = findViewById(R.id.txt_item);
        img_item_small = findViewById(R.id.txt_item3);

        reloadbck = findViewById(R.id.reloadbck);
        bcktohomebtn = findViewById(R.id.bcktohomebtn);

        reloadbck.setVisibility(View.GONE);
        bcktohomebtn.setVisibility(View.GONE);

        update_data();
    }







    int index = 0 ;


    public void next(View view) {
        index++;
        if (index >= (images.length)) {
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
         mp = MediaPlayer.create(this, sound[index]);

        mp.start();
        int idx = new Random().nextInt(closeAnimation.length);

        Animation a = AnimationUtils.loadAnimation(this, closeAnimation[idx]);
        txt_item.startAnimation(a);
        txt_item.setText(text[index]);
        Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
        txt_item.startAnimation(o);


        img_item_small.startAnimation(a);
        img_item_small.setText(stext[index]);
        img_item_small.startAnimation(o);



        update_image();
    }


    void update_image() {

        int idx = new Random().nextInt(closeAnimation.length);

        Animation a = AnimationUtils.loadAnimation(this, closeAnimation[idx]);
        img_item.startAnimation(a);
        img_item.setImageResource(images[index]);
        Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
        img_item.startAnimation(o);


    }






    int[] images = {
            R.drawable.fruits_apple_img, R.drawable.img_ball, R.drawable.animals_img_2,R.drawable.animals_img_3, R.drawable.fruits_lem_img,
            R.drawable.img_flower, R.drawable.img_glasses, R.drawable.img_hat,R.drawable.img_ice_cream, R.drawable.img_juice,

            R.drawable.img_key, R.drawable.fruits_ban_img, R.drawable.fruits_lem_img,R.drawable.fruits_ban_img, R.drawable.fruits_lem_img,
            R.drawable.fruits_apple_img, R.drawable.fruits_ban_img, R.drawable.fruits_lem_img,R.drawable.fruits_ban_img, R.drawable.fruits_lem_img,
            R.drawable.fruits_apple_img, R.drawable.fruits_ban_img, R.drawable.fruits_lem_img,R.drawable.fruits_ban_img



    };
    String[] text = {


            "A", "B", "C" , "D", "E", "F" , "G", "H", "I" , "J", "K", "L" , "M", "N", "O" , "P", "Q", "R"
            , "S"
            , "T"
            , "U"
            , "V"
            , "W"
            , "x", "Y", "X"




    };

    String[] stext = {


            " Apple", "Ball",  "Cat" , " Dog", "Egg", "Flower" , "Glasses", "Hat", "Ice Cream" , "Juice", "Key", "L" , "M", "N", "O" , "P", "Q", "R"
            , "S"
            , "T"
            , "U"
            , "V"
            , "W"
            , "x", "Y", "X"




    };


    int[] sound= { R.raw.sound_alphabet_a,
            R.raw.sound_alphabet_b,  R.raw.sound_alphabet_c, R.raw.sound_alphabet_d,R.raw.sound_alphabet_e, R.raw.sound_alphabet_f,
            R.raw.sound_alphabet_g, R.raw.sound_alphabet_h, R.raw.sound_alphabet_i, R.raw.sound_alphabet_j, R.raw.sound_alphabet_k,
            R.raw.sound_alphabet_l, R.raw.sound_alphabet_m,R.raw.sound_alphabet_n, R.raw.sound_alphabet_o,R.raw.sound_alphabet__p,
            R.raw.sound_alphabet_q, R.raw.sound_alphabet_s,R.raw.sound_alphabet_t, R.raw.sound_alphabet_u,R.raw.sound_alphabet_v,
            R.raw.sound_alphabet_w, R.raw.sound_alphabet_x,R.raw.sound_alphabet_y,R.raw.sound_alphabet_x



    };
}
