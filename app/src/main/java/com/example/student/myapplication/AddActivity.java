package com.example.student.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed = (EditText)findViewById(R.id.editText);
    }
    public void clickBack (View v){
        finish();
    }
    public void clickOk (View v){
        String data = ed.getText().toString();
        Intent it = new Intent();
        it.putExtra("data",data);
        setResult(RESULT_OK,it);
        finish();
    }
}
