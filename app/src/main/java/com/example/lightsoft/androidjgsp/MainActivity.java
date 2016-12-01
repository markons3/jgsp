package com.example.lightsoft.androidjgsp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, new BaseFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                fragment = new BaseFragment();
                if (item.getItemId() == R.id.itemFirst) {
                    fragment = new Fragment1();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (item.getItemId() == R.id.itemSecond) {
                    fragment = new Fragment2();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (item.getItemId() == R.id.itemThird) {
                    fragment = new Fragment3();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
                return false;
            }
        });


    }
}

