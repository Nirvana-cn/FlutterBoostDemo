
package com.example.mnist;

import android.app.Application;
import android.content.Intent;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;

import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterBoost.instance().setup(this, new FlutterBoostDelegate() {
            @Override
            public void pushNativeRoute(FlutterBoostRouteOptions options) {
                String page = options.pageName();
                Log.d("===123 native", page);
                if ("/detail".equals(page)) {
                    Intent intent = new Intent(FlutterBoost.instance().currentActivity(), DetailActivity.class);
                    FlutterBoost.instance().currentActivity().startActivity(intent);
                }
                if ("/about".equals(page)) {
                    Intent intent = new Intent(FlutterBoost.instance().currentActivity(), AboutActivity.class);
                    FlutterBoost.instance().currentActivity().startActivity(intent);
                }
            }

            @Override
            public void pushFlutterRoute(FlutterBoostRouteOptions options) {
                Log.d("===123 flutter", options.pageName());
                Intent intent = new FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity.class)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                        .destroyEngineWithActivity(false)
                        .uniqueId(options.uniqueId())
                        .url(options.pageName())
                        .urlParams(options.arguments())
                        .build(FlutterBoost.instance().currentActivity());

                FlutterBoost.instance().currentActivity().startActivity(intent);
            }
        }, engine -> {
        });
    }
}
