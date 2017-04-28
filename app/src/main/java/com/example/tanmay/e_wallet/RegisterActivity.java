package com.example.tanmay.e_wallet;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText edittext = (EditText) findViewById(R.id.dob);

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }

        };


        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegisterActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }


    public void backPressed(View view) {
        onBackPressed();
    }

    public void insertPressed(View view) {
        TextInputLayout tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilEmail.setError(null);
        EditText balance = tilEmail.getEditText();
        int bal = Integer.parseInt(balance.getText().toString());
        if (bal < 1000) {
            tilEmail.setError("Low Balance!");
        } else {
            String mobNo, name, city, dob, amount;
            EditText m, n, c, d, a;
            m = (EditText) findViewById(R.id.mNo);
            n = (EditText) findViewById(R.id.name);
            c = (EditText) findViewById(R.id.city);
            d = (EditText) findViewById(R.id.dob);
            a = (EditText) findViewById(R.id.balance);
            mobNo = m.getText().toString();
            name = n.getText().toString();
            city = c.getText().toString();
            dob = d.getText().toString();
            amount = a.getText().toString();
            DataBaseHelper myDB = new DataBaseHelper(this);
            myDB.insertData(mobNo, name, city, dob, amount);
            Cursor data = myDB.getData();
            while (data.moveToNext()) {
                Log.i("Daata", data.getString(1));
                Log.i("Daata", data.getString(2));
                Log.i("Daata", data.getString(3));
                Log.i("Daata", data.getString(4));
                Log.i("Daata", data.getString(5));

            }
        }


    }
}
