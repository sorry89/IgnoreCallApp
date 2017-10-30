package com.jhn.shc.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startSettingsActivity();
    }
    private void startSettingsActivity() {
        startActivity(new Intent(this, Settings.class));
        finish();
    }
}



