/*
* This class for welcome page in our project .
* in this pare just content two button one for sign-in another for sign-up
* and just linkpu with second(sign up) and third activity(sign in)
*
* */

package com.example.asus_pc.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id of sign up button (button1) and sign in button(button2)
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        // call sign up and sign in
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // linkup mainActivity to secondActivity
        if(v.getId() == R.id.button1){
            Intent inten = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(inten);
        }
        // linkup mainActivity to thirdActivity
        if(v.getId() == R.id.button2){
            Intent inten = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(inten);
        }
    }
}

