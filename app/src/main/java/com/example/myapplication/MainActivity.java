package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   EditText etName, etFamily, etAge;
   Button btnSubmit;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      etName = findViewById(R.id.etName);
      etFamily = findViewById(R.id.etFamily);
      etAge = findViewById(R.id.etAge);
      btnSubmit = findViewById(R.id.btnSubmit);

      // اگر قبلاً اطلاعات ذخیره شده باشد
      User savedUser = SharedPrefManager.getUser(this);
      if (!savedUser.getName().isEmpty()) {
         etName.setText(savedUser.getName());
         etAge.setText(savedUser.getAge());
         etFamily.setText(savedUser.getFamily());
      }

      btnSubmit.setOnClickListener(v -> {
         String name = etName.getText().toString();
         String family = etFamily.getText().toString();
         String age = etAge.getText().toString();
         User user = new User(name, family, age);

         Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
         intent.putExtra("name", name);
         intent.putExtra("family", family);
         intent.putExtra("age", age);
         startActivity(intent);
      });
   }
}