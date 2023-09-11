package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_j_gotoRegister;
    TextView tv_j_welcome;
    ListView lv_j_users;
    //Intents are used to access other activity pages
    Intent int_j_registerIntent;
    //Looking at class variables and looking at what happens to this class when returning from Register.java
    static int x = 5;
    static boolean leftPage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("x",x+"");
        btn_j_gotoRegister   = findViewById(R.id.btn_v_gotoRegister);
        tv_j_welcome         = findViewById(R.id.tv_v_welcome);
        lv_j_users           = findViewById(R.id.lv_v_listOfNames);
        //The intent you came from (MainActivity.this), and the intent you want to load (Register.class)
        int_j_registerIntent = new Intent(MainActivity.this, Register.class);

        if (leftPage)
        {
            Intent cameFrom = getIntent();
            Bundle infoPassed = cameFrom.getExtras();
            String info = infoPassed.getString("InfoPass");
            Log.d("Info Passed",info);
        }

        registerButtonEventHandler();
    }

    public void registerButtonEventHandler()
    {
        btn_j_gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                leftPage = true;
                x++;
                Log.d("x button press: ",x+"");
                //Log.d("Button Press ---","Register Button Press");
                int_j_registerIntent.putExtra("InfoPass","Hello from Main");
                //Go to the registration intent.
                startActivity(int_j_registerIntent);
            }
        });
    }
}