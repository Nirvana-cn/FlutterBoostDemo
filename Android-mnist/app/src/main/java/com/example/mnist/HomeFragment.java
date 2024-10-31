package com.example.mnist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;

import java.util.HashMap;


public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.home_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlutterBoostRouteOptions options = new FlutterBoostRouteOptions.Builder()
                        .pageName("/product")
                        .arguments(new HashMap<>())
                        .requestCode(1111)
                        .build();
                FlutterBoost.instance().open(options);
            }
        });
    }
}