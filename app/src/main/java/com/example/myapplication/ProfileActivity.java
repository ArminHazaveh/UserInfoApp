package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
   TextView tvName, tvFamily, tvAge;
   Button btnSave;
   String name, family, age;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_profile);

      tvName = findViewById(R.id.tvName);
      tvFamily = findViewById(R.id.tvFamily);
      tvAge = findViewById(R.id.tvAge);
      btnSave = findViewById(R.id.btnSave);

      Intent intent = getIntent();
      name = intent.getStringExtra("name");
      family = intent.getStringExtra("family");
      age = intent.getStringExtra("age");

      tvName.setText(name);
      tvFamily.setText(family);
      tvAge.setText(age);

      btnSave.setOnClickListener(v -> {
         User user = new User(name, family, age);
         SharedPrefManager.saveUser(this, user);
         Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();
         finish(); // برگشت به MainActivity
      });
   }
}
