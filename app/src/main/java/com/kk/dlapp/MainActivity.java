package com.kk.dlapp;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kk.dl.internal.DLIntent;
import com.kk.dl.internal.DLPluginManager;
import com.kk.dl.utils.DLUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    String pluginPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pluginPath = getFilesDir().getAbsolutePath() + "/plugin/plugin-debug.apk";
        DLPluginManager.getInstance(this).loadApk(pluginPath);
    }

    public void onClick(View view) {
        PackageInfo packageInfo = DLUtils.getPackageInfo(this, pluginPath);
        DLIntent intent = new DLIntent(packageInfo.packageName, packageInfo.activities[0].name);
        DLPluginManager.getInstance(this).startPluginActivity(this, intent);
    }

}
