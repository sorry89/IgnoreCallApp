package com.jhn.shc.testapp2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

public class MyPreferenceFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener {

    private final static String TAG = MyPreferenceFragment.class.getSimpleName();

    // must be the same keys as used in /res/xml/prefs.xml
    private final static String SW1 = "switch1";
    private final static String SW2 = "switch2";
    private final static String SW3 = "switch3";
    private final static String PREF_GIVE_ME_A_NUMBER = "key_give_me_a_number";

    boolean tSW1;
    boolean tSW2;
    boolean tSW3;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting_test1);

        // attach change listeners to the preference widgets
        // listner 등록
        findPreference(SW1).setOnPreferenceChangeListener(this);
        findPreference(SW2).setOnPreferenceChangeListener(this);
        findPreference(SW3).setOnPreferenceChangeListener(this);
        findPreference(PREF_GIVE_ME_A_NUMBER).setOnPreferenceChangeListener(this);

        // init the summary of the 'Give me a number' preference widget with its value
        int aNumber = getPreferenceManager().getSharedPreferences().getInt(PREF_GIVE_ME_A_NUMBER, 0);
        Preference giveMeANumberPreference = findPreference(PREF_GIVE_ME_A_NUMBER);
        giveMeANumberPreference.setSummary(Integer.toString(aNumber) + "min");

        //fragment 에서 메뉴를 사용하기 위해 호출해야 함

        // OptionMenu를 사용할지 결정
        // 이 부분을 설정해줘야 onCreateOptionsMenu 함수가 호출 됩니다.

    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    /**
     * Called when a Preference has been changed by the user. This is called before the state of the
     * Preference is about to be updated and before the state is persisted. Return true to persist
     * the changed value, or false to ignore the change.
     */
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        // show that a preference is about to be updated
        // return whether to allow or block the update
        //
        switch (preference.getKey()) {
            case SW1:
                tSW1 = Boolean.valueOf(newValue.toString());
                Constant.S_SW1 = newValue.toString();
                Log.i(TAG, String.format("PREF_PERSISTS_PREFERENCES(value: %s)", newValue.toString()));
                Log.i(TAG, String.format("Reset1 SW1: %b, SW2:%b,SW3:%b",tSW1,tSW2,tSW3));
                return true;
            case SW2:
                tSW2 = Boolean.valueOf(newValue.toString());
                Constant.S_SW2 = newValue.toString();
                Log.i(TAG, String.format("SW2(value: %s)", newValue.toString()));
                Log.i(TAG, String.format("Reset2 SW1: %b, SW2:%b,SW3:%b",tSW1,tSW2,tSW3));
                return true;
            case SW3:
                tSW3 = Boolean.valueOf(newValue.toString());
                Constant.S_SW3 = newValue.toString();
                Log.i(TAG, String.format("SW2(value: %s)", newValue.toString()));
                Log.i(TAG, String.format("Reset3 SW1: %b, SW2:%b,SW3:%b",tSW1,tSW2,tSW3));
                return true;
            case PREF_GIVE_ME_A_NUMBER:
                // we want this preference to only be persisted when PREF_PERSIST_PREFERENCES is set to true.
                boolean allowChange = getPreferenceManager().getSharedPreferences().getBoolean(SW1, false);
                if (allowChange) {
                    // update the summary of the 'Give me a number' preference widget with its new value
                    preference.setSummary(newValue.toString()+"min");
                }
                return allowChange;
            default:
                return true;
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // show when a preference is actually being persisted.
        Log.i(TAG, String.format("onSharedPreferenceChanged(key: %s)", key));
    }

}