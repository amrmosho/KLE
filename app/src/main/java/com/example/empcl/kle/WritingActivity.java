package com.example.empcl.kle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.empcl.kle.lib.MyActivity;

import java.util.Random;

public class WritingActivity extends MyActivity {


    DrawingView dv;
    private Paint mPaint;
    TextView[] txt_item;
    RelativeLayout rvtrans;
    TextView myTitle;


    TextView data_label, title;
    ImageView reloadbck, bcktohomebtn;
    String type = "";



    ConstraintLayout mtile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);


        mtile = findViewById(R.id.drwing_arae);




        txt_item = new TextView[]{findViewById(R.id.txt_item), findViewById(R.id.txt_w_item)};




        data_label = findViewById(R.id.data_label);

        title = findViewById(R.id.title);


        reloadbck = findViewById(R.id.reloadbck);
        bcktohomebtn = findViewById(R.id.bcktohomebtn);

        reloadbck.setVisibility(View.GONE);
        bcktohomebtn.setVisibility(View.GONE);




        if (getIntent().hasExtra("type")) {

            type = getIntent().getStringExtra("type");

        }


        myTitle = findViewById(R.id.myTitle);


        if (type.equals("alphabet")) {

            data = alphabet;
            sound = sound_alphabet;

            myTitle.setText(" Writing Alphabet");

        } else {

            myTitle.setText(" Writing Number");


        }





        next(null);
    }





    int images_index = -1;

    public void next(View view) {
        images_index++;
        if (images_index >= (data.length)) {
            images_index--;
            reloadbck.setVisibility(View.VISIBLE);
            bcktohomebtn.setVisibility(View.VISIBLE);

        } else {


            update_Text();

        }


    }


    public void prev(View view) {
        images_index--;
        if (images_index < 0) {
            images_index = (data.length - 1);
        }

        update_Text();


    }




    MediaPlayer mp;

    void update_Text() {
        if (mp != null) {
            mp.stop();
        }
        update_drwing();

        mp = MediaPlayer.create(this, sound[images_index]);
        mp.start();

        String l = "Number";
        data_label.setText("Write " + l + " " + data[images_index]);


        for (TextView ta : txt_item) {


            int idx = new Random().nextInt(closeAnimation.length);


            Animation a = AnimationUtils.loadAnimation(this, closeAnimation[idx]);

            ta.startAnimation(a);
            ta.setText(data[images_index]);
            Animation o = AnimationUtils.loadAnimation(this, openAnimation[idx]);
            ta.startAnimation(o);

        }


    }


    String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    int[] sound = {
            R.raw.sound_numbers_1,
            R.raw.sound_numbers_2,
            R.raw.sound_numbers_3,
            R.raw.sound_numbers_4,
            R.raw.sound_numbers_5,
            R.raw.sound_numbers_6,
            R.raw.sound_numbers_7,
            R.raw.sound_numbers_8,
            R.raw.sound_numbers_9,
            R.raw.sound_numbers_10
    };





    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    int[] sound_alphabet = {
            R.raw.sound_alphabet_a,
            R.raw.sound_alphabet_b,
            R.raw.sound_alphabet_c,
            R.raw.sound_alphabet_d,
            R.raw.sound_alphabet_e,
            R.raw.sound_alphabet_f,
            R.raw.sound_alphabet_g,
            R.raw.sound_alphabet_h,
            R.raw.sound_alphabet_i,
            R.raw.sound_alphabet_j,
            R.raw.sound_alphabet_k,
            R.raw.sound_alphabet_l,
            R.raw.sound_alphabet_m,
            R.raw.sound_alphabet_n,
            R.raw.sound_alphabet_o,
            R.raw.sound_alphabet__p,
            R.raw.sound_alphabet_q,
            R.raw.sound_alphabet_r,
            R.raw.sound_alphabet_s,
            R.raw.sound_alphabet_t,
            R.raw.sound_alphabet_u,
            R.raw.sound_alphabet_v,
            R.raw.sound_alphabet_w,
            R.raw.sound_alphabet_x,
            R.raw.sound_alphabet_y,
            R.raw.sound_alphabet_z,


    };

















    void update_drwing() {
        if (dv != null) {

            mtile.removeView(dv);

        }
        if (rvtrans != null) {


            mtile.removeView(rvtrans);

        }


        dv = new DrawingView(this);

        mtile.addView(dv);


        rvtrans = new RelativeLayout(this);
        mtile.addView(rvtrans);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);


        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(25);


    }



    public class DrawingView extends View {


        private Bitmap mBitmap;
        private Canvas mCanvas;


        private Path mPath;

        private Paint mBitmapPaint;


        Context context;


        public DrawingView(Context c) {
            super(c);
            context = c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);

        }



        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);

        }




        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath(mPath, mPaint);
        }





        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;




        @Override
        public boolean onTouchEvent(MotionEvent event) {


            float x = event.getX();
            float y = event.getY();



            switch (event.getAction()) {


                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }



        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }





        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);

            if ((dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)) {
                mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                mX = x;
                mY = y;

            }
        }



        private void touch_up() {


            mPath.lineTo(mX, mY);

            mCanvas.drawPath(mPath, mPaint);

            mPath.reset();
        }






    }





}
