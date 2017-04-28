package com.example.tanmay.e_wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendMoneyActivity extends AppCompatActivity {
    EditText amt, phNo;
    String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
        Intent intent = getIntent();
        from = intent.getStringExtra("mNo");
        amt = (EditText) findViewById(R.id.sendMoneyAmount);
        phNo = (EditText) findViewById(R.id.sendMoneymNo);
    }

    public void clear(View view) {
        amt.setText("");
        phNo.setText("");
    }

    public void send(View view) {
        String sendTo = phNo.getText().toString();
        String tran = from.substring(4) + sendTo.substring(4);
        Toast.makeText(this, tran, Toast.LENGTH_SHORT).show();
    }
}
