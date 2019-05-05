package com.example.parul.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Appointment extends AppCompatActivity {

    private static EditText date_appointment, time_appointment;
    private static Button SendRequest;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        date_appointment = (EditText) findViewById(R.id.date);
        time_appointment = (EditText) findViewById(R.id.time);
        SendRequest = (Button) findViewById(R.id.request);
        Intent intent = getIntent();
        final String phonenumber = intent.getStringExtra("phone");

        SendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = date_appointment.getText().toString();
                String time = time_appointment.getText().toString();
                String msg = ("Hello doctor!! Can you please fix an appointment with me on " + date + " at " + time);
                sendSmsBySIntent(msg, phonenumber);
            }
        });

    }

    public void sendSmsBySIntent(String msg, String phonenumber) {
        // add the phone number in the data
        Uri uri = Uri.parse("smsto:" + phonenumber);

        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
        // add the message at the sms_body extra field
        smsSIntent.putExtra("sms_body", msg);
        try {
            startActivity(smsSIntent);
        } catch (Exception ex) {
            Toast.makeText(Appointment.this, "Your sms has failed...", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
