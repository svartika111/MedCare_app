package com.example.parul.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mailing extends AppCompatActivity {

     EditText msg, sub;
     Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailing);
        Intent intent = getIntent();
        final String mailid = intent.getStringExtra("email");

        btn = (Button) findViewById(R.id.btnsave);
        msg = (EditText) findViewById(R.id.message);
        sub = (EditText) findViewById(R.id.subject);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = msg.getText().toString();
                String subject = sub.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {mailid});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose Email client :"));

            }
        });
    }
}
