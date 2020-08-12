package com.hss01248.containerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.hss01248.rnmodule.MyReactActivity;

import de.robv.android.xposed.DexposedBridge;
import de.robv.android.xposed.XC_MethodHook;
import hexin.androidbitmapcanary.ActivityDrawableWatcher;
import hexin.androidbitmapcanary.BitmapListUtil;
import hexin.androidbitmapcanary.ImgMemoryActivity;

import static de.robv.android.xposed.XposedBridge.TAG;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityDrawableWatcher.watchDrawable(getApplication());
        //hook();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void hook() {
        DexposedBridge.hookAllConstructors(CloseableStaticBitmap.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                CloseableStaticBitmap thread = (CloseableStaticBitmap) param.thisObject;
                Log.d(TAG, "CloseableStaticBitmap: " + thread);
                // bitmap: 960x600 obj:com.facebook.imagepipeline.image.CloseableStaticBitmap@ebb5bb2 is created.

                //downsample+resize:
                // bitmap: 240x150 obj:com.facebook.imagepipeline.image.CloseableStaticBitmap@ebb5bb2 is created.
                Bitmap bitmap = thread.getUnderlyingBitmap();
                if(bitmap != null){
                    BitmapListUtil.add(bitmap);
                    Log.d(TAG, "bitmap: " + bitmap.getWidth()+"x"+bitmap.getHeight() + " obj:" + thread +  " is created.");
                }
            }
        });
    }

    public void rn(View view){
        try {
            startActivity(new Intent(this, MyReactActivity.class));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImgMemoryActivity.start(MainActivity.this);
                }
            },3000);

        }catch (Throwable throwable){
            throwable.printStackTrace();
        }


    }

    public void flutter(View view){

    }
}
