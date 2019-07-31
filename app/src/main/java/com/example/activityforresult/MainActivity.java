package com.example.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main_activity;
    private Button btn_getResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_main_activity = findViewById(R.id.tv_main_activity);
        btn_getResult = findViewById(R.id.btn_getResult);


        btn_getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
//                getResultFromButton();
//                transition();
            }
        });
    }

    //checking + sending the data to the first activity
    @Override
    //request Code (we set the parameter), for this method we have declared the int = 1
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //checking if the requestCode is true
        if(requestCode == 1){
            //has everything gone ok?
            if(resultCode == RESULT_OK){
                tv_main_activity.setText(data.getStringExtra("result"));
                Log.i("MainActivity", "onActivityResult: " + data.getStringExtra("result"));
            }
        }
        if(resultCode == RESULT_CANCELED){
            //Handle case
        }

    }


}
