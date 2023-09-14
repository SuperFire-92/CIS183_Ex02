package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity
{

    Button btn_j_r_back;
    Button btn_j_r_register;
    TextView tv_j_r_register;
    EditText et_j_r_fName;
    EditText et_j_r_lName;
    Intent int_j_mainActivityIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_j_r_back = findViewById(R.id.btn_v_r_back);
        btn_j_r_register = findViewById(R.id.btn_v_r_register);
        tv_j_r_register = findViewById(R.id.tv_v_r_register);
        et_j_r_fName = findViewById(R.id.et_v_r_fName);
        et_j_r_lName = findViewById(R.id.et_v_r_lName);

        int_j_mainActivityIntent = new Intent(Register.this, MainActivity.class);

        //Code to get info passed from mainactivity.java
        //get the intent that called me
        Intent cameFrom = getIntent();
        //get the bundle that was padded to me from "cameFrom"
        Bundle infoPassedToMe = cameFrom.getExtras();
        //Get the info in the bundle called "InfoPass" which was set in MainActivity.java
        String info = infoPassedToMe.getString("InfoPass");
        //display message passed from MainActivity.java
        Log.d("Info Passed from main: ", info);

        backButtonEventHandler();
        registerButtonEventHandler();
    }
    public void backButtonEventHandler()
    {
        btn_j_r_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Button Press","Back Button Pressed");
                int_j_mainActivityIntent.putExtra("InfoPass","");
                startActivity(int_j_mainActivityIntent);
            }
        });
    }

    public void registerButtonEventHandler()
    {
        btn_j_r_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button Press","Register Button Pressed");
                String fName = et_j_r_fName.getText().toString();
                int_j_mainActivityIntent.putExtra("InfoPass",fName);
                startActivity(int_j_mainActivityIntent);
            }
        });
    }
}