package com.example.empcl.kle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.empcl.kle.lib.MyActivity;

public class HomeActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void gotoAlpha(View view) {
        Intent i = new Intent(this, AlphaActivity.class);
        startActivity(i);
    }

    public void numbers(View view) {

        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }


    public void writing_numbers(View view) {
        Intent i = new Intent(this, WritingActivity.class);
        i.putExtra("type" ,"numbers");
        startActivity(i);
    }
    public void weiting_alpha(View view) {

        Intent i = new Intent(this, WritingActivity.class);
        i.putExtra("type" ,"alphabet");
        startActivity(i);
    }




    public void fruits(View view) {

        Intent i = new Intent(this, ItemsActivity.class);
        i.putExtra("type" ,"fruits");
        startActivity(i);
    }

    public void anmials(View view) {


        Intent i = new Intent(this, ItemsActivity.class);
        i.putExtra("type" ,"anmials");
        startActivity(i);
    }

    public void months(View view) {

        Intent i = new Intent(this, ItemsActivity.class);
        i.putExtra("type" ,"months");
        startActivity(i);
    }

    public void days(View view) {

        Intent i = new Intent(this, ItemsActivity.class);
        i.putExtra("type" ,"days");
        startActivity(i);
    }



}
