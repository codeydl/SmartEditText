package com.itydl.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.itydl.myapplication.bean.TextObj;
import com.itydl.myapplication.view.SelfEditText;

public class MainActivity extends AppCompatActivity {

    private SelfEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (SelfEditText) findViewById(R.id.et);
        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextObj textObj = new TextObj();
                textObj.setObjectRule("#");
                textObj.setObjectText("在此输入成为话题");
                mEditText.setObject(textObj);
            }
        });
    }
}
