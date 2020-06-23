package com.example.universityranking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAuthFragment();
    }

    private void showAuthFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new AuthenticationView())
                .commit();
    }
}
