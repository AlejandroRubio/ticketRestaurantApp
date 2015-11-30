package com.example.tickets.tickets;

    import android.os.Bundle;
    import android.preference.PreferenceActivity;

    public class ActividadPreferencias extends PreferenceActivity {
        @Override protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }
    }