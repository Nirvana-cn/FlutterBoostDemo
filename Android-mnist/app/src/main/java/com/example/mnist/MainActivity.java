package com.example.mnist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment homeFragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
    }
}
