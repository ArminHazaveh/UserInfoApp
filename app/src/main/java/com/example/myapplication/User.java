package com.example.myapplication;

public class User {
   String name;
   String family;
   int age;

   public User(String name, String family, int age) {
      this.name = name;
      this.family = family;
      this.age = age;
   }

   // گتر و ستر
   public String getName() {
      return name;
   }

   public String getFamily() {
      return family;
   }

   public int getAge() {
      return age;
   }
}
