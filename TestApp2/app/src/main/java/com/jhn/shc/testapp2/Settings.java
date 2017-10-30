package com.jhn.shc.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment())
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.true
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //누를 때 이미 값들이 바뀌어있다
        int id = item.getItemId();
        Log.i("before", String.format("Reset1 SW1: %b, SW2:%b,SW3:%b",Constant.a,Constant.b,Constant.c));
        String txt = "";
        if (id == R.id.apply) {

            txt = "clicked apply button";
            Log.d("CLICK!!",txt);
            Log.i("after", String.format("Reset1 SW1: %b, SW2:%b,SW3:%b",Constant.a,Constant.b,Constant.c));
            //여기서 기존에 실행하던 서비스를 중지하고 새롭게 다시 시작하는 것으로!

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startSettingsActivity() {
        startActivity(new Intent(this, Settings.class));
        finish();
    }
}
