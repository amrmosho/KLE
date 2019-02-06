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

public class ItemsActivity extends MyActivity {
    ImageView img_item;
    TextView txt_item,myTitle;
    ImageView reloadbck,bcktohomebtn;

    String  type ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        img_item = findViewById(R.id.img_item);
        txt_item = findViewById(R.id.txt_item);
        myTitle = findViewById(R.id.myTitle);


        if ( getIntent().hasExtra("type")){

            type = getIntent().getStringExtra("type");

        }




        update_data();


        reloadbck = findViewById(R.id.reloadbck);
        bcktohomebtn = findViewById(R.id.bcktohomebtn);



        reloadbck.setVisibility(View.GONE);
        bcktohomebtn.setVisibility(View.GONE);





    }





    void update_data() {

        if (type.equalsIgnoreCase("months")){
            images = images_moths;
            sound = sound_moths;
            text = text_months;

            myTitle.setText("Months");
        }else   if (type.equalsIgnoreCase("days")){
            images = images_days;
            sound = sound_days;
            text = text_days;
            myTitle.setText("Days");

        }else   if (type.equalsIgnoreCase("anmials")){
            images = images_animals;
            sound = sound_animals;
            text = text_animals;
            myTitle.setText("Animals");
        }else  {
            images = images_fruits;
            sound = sound_fruits;
            text = text_fruits;
            myTitle.setText("Fruits");
        }




        update_image();
        update_Text();
    }



    int images_index = 0;




    public void next(View view) {
        images_index++;


        if (images_index >= (images.length)) {
            images_index--;
            reloadbck.setVisibility(View.VISIBLE);
            bcktohomebtn.setVisibility(View.VISIBLE);

            //   images_index = 0;
        }else{


            update_image();
            update_Text();

        }



    }



    public void prev(View view) {
        images_index--;
        if (images_index < 0) {
            images_index = (images.length - 1);
        }

        update_image();
        update_Text();


    }



    MediaPlayer mp;
    void update_Text() {


        if (mp !=null){
            mp.stop();
        }
         mp = MediaPlayer.create(this, sound[images_index]);
        mp.start();


        int idx = new Random().nextInt(closeAnimation.length);

        Animation a = AnimationUtils.loadAnimation(this, closeAnimation[idx]);


        txt_item.startAnimation(a);
        txt_item.setText(text[images_index]);


        Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
        txt_item.startAnimation(o);


    }


    void update_image() {

        int idx = new Random().nextInt(closeAnimation.length);

        Animation a = AnimationUtils.loadAnimation(this, closeAnimation[idx]);
        img_item.startAnimation(a);

        img_item.setImageResource(images[images_index]);


        Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
        img_item.startAnimation(o);


    }








    int[] images = {};
    int[] sound = {};
    String[] text = {};









    // fruits data


    int[] images_fruits = {
            R.drawable.fruits_apple_img,
            R.drawable.fruits_ban_img,
            R.drawable.fruits_lem_img
    };
    String[] text_fruits = {"Apple", "Banana", "lemon"};
    int[] sound_fruits = {R.raw.fruits_apple, R.raw.fruits_ban, R.raw.fruits_lem};





    // animals data

    int[] images_animals = {
            R.drawable.animals_img_1,
            R.drawable.animals_img_2,
            R.drawable.animals_img_3
    };

    String[] text_animals = {"Cow", "Cat", "Dog"};
    int[] sound_animals = {R.raw.animals_sound_1, R.raw.animals_sound_2, R.raw.animals_sound_3};






    // months data

    int[] images_moths = {
            R.drawable.moths_image_jan,
            R.drawable.moths_image_feb,
            R.drawable.moths_image_mar ,
            R.drawable.moths_image_apr,
            R.drawable.moths_image_may,
            R.drawable.moths_image_june,
            R.drawable.moths_image_july,
            R.drawable.moths_image_aug,
            R.drawable.moths_image_sept,
            R.drawable.moths_image_oct,
            R.drawable.moths_image_nov,
            R.drawable.moths_image_dec
    };


    String[] text_months = {
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };

    int[] sound_moths= {
            R.raw.month_j, R.raw.month_f, R.raw.month_m,
            R.raw.moth_a, R.raw.month_may, R.raw.month_julay,
            R.raw.month_julay, R.raw.month_aug, R.raw.month_stp,
            R.raw.month_oc, R.raw.month_nov, R.raw.month_dec};








    // days data

    int[] images_days = {
            R.drawable.img_days_s,
            R.drawable.img_days_m,
            R.drawable.img_days_tu,
            R.drawable.img_days_w,
            R.drawable.img_days_th,
            R.drawable.img_days_f,
            R.drawable.img_days_sa

    };
    String[] text_days = {"sunday", "monday", "Tuesday", "Wendnesday", "Thuraday", "Friday", "Saturday"};
    int[] sound_days = {R.raw.days_s, R.raw.days_m, R.raw.days_tu, R.raw.days_w, R.raw.days_th, R.raw.days_f, R.raw.days_sa};
}

