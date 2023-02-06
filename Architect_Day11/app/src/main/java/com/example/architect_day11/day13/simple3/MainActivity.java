package com.example.architect_day11.day13.simple3;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.architect_day11.BuildConfig;
import com.example.architect_day11.R;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = null;
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "scaleX", 1f);
        animator.setInterpolator(new DecelerateInterpolator());

        animator.setDuration(3000).start();



        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }

        Timber.tag("LifeCycles");
        Timber.e("Activity Created");


        // 开一个线程不断调用 ScaleX 这个方法，传的只是后面 0f,1f,2f 参数
        // 怎么才能调用到 imageView的setScaleX方法，可以通过反射调用
    }

    private static class DebugTree extends Timber.Tree {

        @Override
        protected void log(int i, @Nullable String s, @NonNull String s1, @Nullable Throwable throwable) {
            System.out.println("hello");
           Log.e(s,s1);
        }
    }
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, @NonNull String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            if (t != null) {
                if (priority == Log.ERROR) {

                } else if (priority == Log.WARN) {

                }
            }
        }
    }

}
