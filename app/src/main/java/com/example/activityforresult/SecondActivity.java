package com.example.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText et_display_result;
    private Button btn_back_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_display_result = findViewById(R.id.et_result_Button);
        btn_back_result = findViewById(R.id.btn_display_result);


        btn_back_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResultFromButton();
            }
        });
    }

    //    String result = getIntent().getStringExtra("Result");
//
//
    private void getResultFromButton() {
        //initialise the constructor without any parameters
        Intent intent = new Intent();

        //create the bundle to get data from getText
        intent.putExtra("result",et_display_result.getText().toString());

        //send the data to the receiver of the data "tv_getResult"
        setResult(RESULT_OK,intent);

        //We finally finish the request (it destroys it)
        finish();
    }
}

