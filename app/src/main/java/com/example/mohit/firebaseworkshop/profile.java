package com.example.mohit.firebaseworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class profile extends AppCompatActivity {
    ImageView userimg;
    TextView username, useremail;
    Button signout;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userimg = (ImageView) findViewById(R.id.userimg);
        username = (TextView) findViewById(R.id.username);
        useremail = (TextView) findViewById(R.id.usermail);
        signout=(Button) findViewById(R.id.logout);

        username.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        useremail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        userimg.setImageURI(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl());

//        auth=FirebaseAuth.getInstance();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });

        Picasso.with(getBaseContext()).load(FirebaseAuth.getInstance()
                .getCurrentUser().getPhotoUrl())
                .into(userimg);


    }
}
