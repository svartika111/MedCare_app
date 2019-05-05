package com.example.parul.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddDoctor extends AppCompatActivity {


    SharedPreferences sp;
    SharedPreferences sharedpreferences;
    EditText nm;
    EditText cn;
    EditText ea;

    public static final String mypreference = "mypref";
    public static final String name = "nameKey";
    public static final String contact = "contactKey";
    public static final String email="emailkey";
    ImageView call, mail, appointment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        nm = (EditText) findViewById(R.id.Dname);
        cn = (EditText) findViewById(R.id.Dcontact);
        ea = (EditText) findViewById(R.id.Dmail);


        call = (ImageView) findViewById(R.id.phone);
        mail = (ImageView) findViewById(R.id.email);
        appointment = (ImageView) findViewById(R.id.time);
        sp = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        /*if (sp.contains(name)) {
            name.setText(sp.getString(name, ""));
        }
        if(sharedpreferences.contains(contact)){
            contact.setText(sharedpreferences.getString(contact, ""));
        }
        if (sharedpreferences.contains(email)){
            email.setText(sharedpreferences.getString(email, ""));
        }*/

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(name)) {
            nm.setText(sharedpreferences.getString(name, ""));
        }
        if (sharedpreferences.contains(email)) {
            ea.setText(sharedpreferences.getString(email, ""));

        }
        if (sharedpreferences.contains(contact)) {
            cn.setText(sharedpreferences.getString(contact, ""));

        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = cn.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(AddDoctor.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Docail = ea.getText().toString();
                Intent intent = new Intent(AddDoctor.this, Mailing.class);
                intent.putExtra("email",Docail);
                startActivity(intent);
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String DocPhone = cn.getText().toString();
                Intent intent = new Intent(AddDoctor.this, Appointment.class);
                intent.putExtra("phone",  DocPhone);
                startActivity(intent);
            }
        });


    }



    public void Save(View view) {
        String n = nm.getText().toString();
        String e = ea.getText().toString();
        String c = cn.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(name, n);
        editor.putString(email, e);
        editor.putString(contact,c);
        editor.commit();
        if(nm.getText().toString().isEmpty() )
        {

            nm.setError("please enter your Name");
            return;
        }
        if(ea.getText().toString().isEmpty() )
        {
            ea.setError("please enter your email");

            return;
        }
        if(cn.getText().toString().isEmpty() )
        {
            cn.setError("please enter your contact");

            return;
        }
        Toast.makeText(AddDoctor.this, "Doctor has been added", Toast.LENGTH_SHORT).show();

    }



}
