package com.example.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.test.ImageTest.TestFragment;
import com.example.test.ObjectAnimation.ObjectAnimationFragment;
import com.example.test.databinding.MainActivityBinding;
import com.example.test.transactionstest.BaseFragment;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity {
    MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        //setContentView(R.layout.activity_main);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /* *//* //using external library for expandable view
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new RMainFragment()).commit();*//*

         *//* //expandable view without any library
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new CRMainFragment()).commit();*//*

        //draggable panel with own custom library
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new DraggablePannelFragment()).commit();*/

        //object animator
       // getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new ObjectAnimationFragment()).commit();

        //base 64 images
        //getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, TestFragment.newInstance(null,null)).commit();

        //transaction shred elemet
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, BaseFragment.newInstance(null,null)).commit();

       /* mainActivityBinding.ivLead.setOnTouchListener(new View.OnTouchListener() {
            float lastX, lastY;

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent)
            {



                if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
                    float deltaX = motionEvent.getRawX() - lastX;
                    float deltaY = motionEvent.getRawY() - lastY;

                    mainActivityBinding.ivLead.setTranslationX(deltaX + mainActivityBinding.ivLead.getTranslationX());
                    mainActivityBinding.ivLead.setTranslationY(deltaY + mainActivityBinding.ivLead.getTranslationY());

                }
                lastX = motionEvent.getRawX();
                lastY = motionEvent.getRawY();

                return true;
            }
        });*/

    }
}
