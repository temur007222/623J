package com.example.a623j;

import androidx.annotation.NonNull;

public class MyObject {
    String age;
    String name;

    public MyObject(String age, String name) {
        this.age = age;
        this.name = name;
    }

     @NonNull
     @Override
     public String toString() {
         return "MyObject{" +
                 "age='" + age + '\'' +
                 ", name='" + name + '\'' +
                 '}';
     }
 }
