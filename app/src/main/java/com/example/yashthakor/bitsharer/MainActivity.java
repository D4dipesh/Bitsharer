package com.example.yashthakor.bitsharer;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button button_sbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void OnclickButton1(View V)
    {
        button_sbm=(Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.yashthakor.bitsharer1");
                        startActivity(intent);
                    }
                }
        );

    }
    public void OnclickButton2(View V)
    {
        button_sbm=(Button)findViewById(R.id.button2);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.example.yashthakor.bitsharer2");
                        startActivity(intent);
                    }
                }
        );
    }
}
