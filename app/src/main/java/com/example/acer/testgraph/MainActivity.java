package com.example.acer.testgraph;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    //MyGraph newView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment = new Fragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        Bundle bundle = new Bundle();
        bundle.putString("testing", "This information came from Main Activity");

        GraphFragment fragmentcode = new GraphFragment();
        fragmentcode.setArguments(bundle);
        fragmentTransaction.add(R.id.layout1,fragmentcode);
        fragmentTransaction.commit();

        //newView = (MyGraph) findViewById(R.id.layout1);



    }



}
