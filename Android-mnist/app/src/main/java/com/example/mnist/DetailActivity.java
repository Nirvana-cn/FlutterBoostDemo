package com.example.mnist;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;

import java.util.HashMap;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViewById(R.id.detail_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlutterBoostRouteOptions options = new FlutterBoostRouteOptions.Builder()
                        .pageName("/profile")
                        .arguments(new HashMap<>())
                        .build();
                FlutterBoost.instance().open(options);
            }
        });

    }
}
