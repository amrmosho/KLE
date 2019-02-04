package com.example.empcl.kle.lib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.empcl.kle.HomeActivity;
import com.example.empcl.kle.R;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


    }

  protected   int[] closeAnimation = {R.anim.close ,R.anim.close_1};
    protected  int[] openAnimation = {R.anim.open ,R.anim.open_2};

    public void gotohome(View view) {

startActivity(new Intent(this ,HomeActivity.class));
    }


    public void reload(View view) {
        finish();
        startActivity(getIntent());


    }

}
