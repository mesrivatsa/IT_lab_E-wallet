package com.example.tanmay.e_wallet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void signInClicked(View view) {
        EditText name, pass;
        name = (EditText) findViewById(R.id.signInName);
        pass = (EditText) findViewById(R.id.signInPass);
        String sname, spass;
        sname = name.getText().toString();
        spass = pass.getText().toString();
        DataBaseHelper myDB = new DataBaseHelper(this);
        Cursor data = myDB.getData();
        while (data.moveToNext()) {
            if (sname.equals(data.getString(2)) && spass.equals(data.getString(1))) {
                Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
                intent.putExtra("mNo", spass);
                startActivity(intent);
            }

        }


    }
}
