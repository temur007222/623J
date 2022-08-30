package com.example.a623j;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("userInfo", 0);

        Button bt = findViewById(R.id.bt);
        EditText et = findViewById(R.id.et);
        EditText name = findViewById(R.id.name);
        EditText age = findViewById(R.id.age);

            bt.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {

                    String name1 = name.getText().toString();
                    String age1 = age.getText().toString();

                    MyObject myObject = new MyObject(age1, name1);

                    SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(myObject);
                    prefsEditor.putString("MyObject", json);
                    prefsEditor.apply();

                    Gson gson1 = new Gson();
                    String json1 = sharedPreferences.getString("MyObject", "");
                    MyObject obj = gson1.fromJson(json1, MyObject.class);
                    et.setText("Name: " + obj.name + "\nAge: " + obj.age);

                }
            });
    }
}