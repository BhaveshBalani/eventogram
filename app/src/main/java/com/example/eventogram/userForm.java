package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class userForm extends AppCompatActivity {
    private EditText uName , uStream, uPhone, uEmail ;
    private Button submit;
    private Button uData;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("sub");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        uData=findViewById(R.id.uData);
        uData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(userForm.this,rUserdata.class);
                startActivity(intent);
            }
        });


        uName   = findViewById(R.id.uName);
        uStream = findViewById(R.id.uStream);
        uPhone  = findViewById(R.id.uPhone);
        uEmail  = findViewById(R.id.uEmail);
        submit  = findViewById(R.id.button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name     = uName.getText().toString();
                String mobile   = uPhone.getText().toString();
                String email    = uEmail.getText().toString();
                String stream   = uStream.getText().toString();

                HashMap<String, String> userMap  =   new HashMap<>();
                userMap.put("name" , name);
                userMap.put("mobile" , mobile);
                userMap.put("email" , email);
                userMap.put("stream" , stream);

                root.push().setValue(userMap);

            }
        });

    }
}