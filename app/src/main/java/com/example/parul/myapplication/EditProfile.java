package com.example.parul.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText inputName, inputEmail,ageuser,inputGender,inputContact,inputEcontact,bloodgroup,allergies,pastp;
    private Button update;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //fetching uid
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userId=currentFirebaseUser.getUid();
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");


        inputName = (EditText) findViewById(R.id.name1);
        inputEmail = (EditText) findViewById(R.id.email1);
        inputContact = (EditText) findViewById(R.id.contact1);
        inputEcontact = (EditText) findViewById(R.id.econtact1);
        inputGender =(EditText) findViewById(R.id.gender1);
        bloodgroup =(EditText) findViewById(R.id.blood1);
        allergies =(EditText) findViewById(R.id.allergies1);
        pastp =(EditText) findViewById(R.id.pastp);
        update = (Button) findViewById(R.id.update);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        // Save / update the user
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String gender = inputGender.getText().toString();
                String contact= inputContact.getText().toString();
                String econtact= inputEcontact.getText().toString();
                String blood= bloodgroup.getText().toString();
                String allergy= allergies.getText().toString();
                String past=pastp.getText().toString();


                updateUser(name,email,gender,contact,econtact,blood,allergy,past);

            }
        });


    }




    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }


    private void updateUser(String name, String email,String gender,String contact,String econtact,String blood,String allergy,String past){
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("name").setValue(name);

        if (!TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("email").setValue(email);
        if (!TextUtils.isEmpty(contact))
            mFirebaseDatabase.child(userId).child("contact").setValue(contact);
        if (!TextUtils.isEmpty(econtact))
            mFirebaseDatabase.child(userId).child("econtact").setValue(econtact);
        if (!TextUtils.isEmpty(gender))
            mFirebaseDatabase.child(userId).child("gender").setValue(gender);
        if (!TextUtils.isEmpty(blood))
            mFirebaseDatabase.child(userId).child("blood").setValue(blood);
        if (!TextUtils.isEmpty(allergy))
            mFirebaseDatabase.child(userId).child("allergy").setValue(allergy);
        if (!TextUtils.isEmpty(past))
            mFirebaseDatabase.child(userId).child("past").setValue(past);

    }
}


