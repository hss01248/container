package com.hss01248.flutter;

import android.os.Bundle;

import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.app.FlutterActivity;
/**
 * by hss
 * data:2020/5/29
 * desc:
 */
public class MyFlutterActivity extends FlutterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
    }
}

