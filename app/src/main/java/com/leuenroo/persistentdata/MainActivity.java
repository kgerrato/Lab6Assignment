package com.leuenroo.persistentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;

import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String NAME = "NAME_KEY";
    public static final String EMAIL = "EMAIL_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(NAME)) {
            name.setText(sharedpreferences.getString(NAME, ""));
        }
        if (sharedpreferences.contains(EMAIL)) {
            email.setText(sharedpreferences.getString(EMAIL, ""));

        }

    }

    public void saveData(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NAME, n);
        editor.putString(EMAIL, e);
        editor.apply();
    }

    public void clear(View view) {

        name.setText("");
        email.setText("");

    }

    public void readData(View view) {

        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(NAME)) {
            name.setText(sharedpreferences.getString(NAME, ""));
        }
        if (sharedpreferences.contains(EMAIL)) {
            email.setText(sharedpreferences.getString(EMAIL, ""));

        }
    }
}


