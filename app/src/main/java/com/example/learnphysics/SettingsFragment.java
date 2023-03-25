package com.example.learnphysics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingsFragment extends Fragment {
    TextView aboutApp;

    public SettingsFragment(){
        // require a empty public constructor
    }
    TextView account;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        aboutApp = (TextView) view.findViewById(R.id.settings_about_app);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(AboutApp.class);
            }
        });
        return view;

    }
    public void openActivity(Class cl){
        Intent intent = new Intent(getContext(),cl);
        startActivity(intent);
    }

}