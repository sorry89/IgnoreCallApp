package com.jhn.shc.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting_test1);

        Intent intent=new Intent(MainActivity.this,PermissionActivity.class);
        startActivity(intent) ;

    }
}

