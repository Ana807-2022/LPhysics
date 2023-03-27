package com.example.learnphysics;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingsFragment extends Fragment {
    TextView aboutApp;
    TextView howToUseApp;

    public SettingsFragment(){
        // require a empty public constructor
    }

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

        howToUseApp = (TextView) view.findViewById(R.id.how_to_use_app);
        howToUseApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(HowToUseApp.class);
            }
        });
        return view;

    }
    public void openActivity(Class cl){
        startActivity(new Intent(getContext(),cl));
    }

}