package com.example.mnist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("one.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ImageView image = findViewById(R.id.image);
            image.setImageBitmap(bitmap);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FlutterBoostRouteOptions options = new FlutterBoostRouteOptions.Builder()
                            .pageName("simplePage")
                            .arguments(new HashMap<>())
                            .requestCode(1111)
                            .build();
                    FlutterBoost.instance().open(options);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
