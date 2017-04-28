package com.example.tanmay.e_wallet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    DataBaseHelper myDB;
    String balance, mNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent = getIntent();
        mNo = intent.getStringExtra("mNo");
        myDB = new DataBaseHelper(this);
        Cursor data = myDB.getData();
        while (data.moveToNext()) {
            if (data.getString(1).equals(mNo))
                balance = data.getString(5);
        }

    }

    public void balanceClicked(View view) {
        Toast.makeText(this, balance, Toast.LENGTH_SHORT).show();
    }

    public void sendMoney(View view) {
        Intent intent = new Intent(WelcomeActivity.this, SendMoneyActivity.class);
        intent.putExtra("mNo", mNo);
        startActivity(intent);
    }
}
