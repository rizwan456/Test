package com.example.test;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.DraggableTest.DraggablePannelFragment;
import com.example.test.databinding.MainActivityBinding;
import com.example.test.expandable_recyclerView.RMainFragment;
import com.example.test.expandable_recyclerView_custom.CRMainFragment;

public class MainActivity extends AppCompatActivity {
    MainActivityBinding mainActivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainActivityBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

       /* //using external library for expandable view
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new RMainFragment()).commit();*/

       /* //expandable view without any library
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new CRMainFragment()).commit();*/

        //draggable panel with own custom library
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new DraggablePannelFragment()).commit();

    }
}
