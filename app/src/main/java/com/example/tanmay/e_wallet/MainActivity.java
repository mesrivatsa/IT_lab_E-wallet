package com.example.tanmay.e_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view) {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

    public void signin(View view) {
        startActivity(new Intent(MainActivity.this, SignInActivity.class));
    }
}
