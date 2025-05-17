package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
   private static final String PREF_NAME = "user_pref";
   private static final String KEY_NAME = "name";
   private static final String KEY_FAMILY = "family";
   private static final String KEY_AGE = "age";

   public static void saveUser(Context context, User user) {
      SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
      SharedPreferences.Editor editor = prefs.edit();
      editor.putString(KEY_NAME, user.getName());
      editor.putString(KEY_FAMILY, user.getFamily());
      editor.putString(KEY_AGE, user.getAge());
      editor.apply();
   }

   public static User getUser(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
      String name = prefs.getString(KEY_NAME, "");
      String family = prefs.getString(KEY_FAMILY, "");
      String age = prefs.getString(KEY_AGE, "");
      return new User(name, family, age);
   }
}


