package com.example.universityranking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            showStartFragment();
        }
    }

    private void showStartFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new StartView())
                .commit();
    }

    private void showAuthFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new AuthenticationView())
                .commit();
    }

}
