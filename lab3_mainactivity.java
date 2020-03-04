package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    EditText n1, n2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText) findViewById(R.id.num1);
        n2 = (EditText) findViewById(R.id.num2);
        res = (TextView) findViewById(R.id.result);
    }

    public void handleEvent(View v) {
        float numb1 = Float.parseFloat(n1.getText().toString());
        float numb2 = Float.parseFloat(n2.getText().toString());
        float result;

        switch (v.getId()) {
            case R.id.add :
                 result = numb1 + numb2;
                 res.setText(Float.toString(result));
                 break;
            case R.id.sub:
                result = numb1 - numb2;
                res.setText(Float.toString(result));
                break;
            case R.id.mul :
                result = numb1 * numb2;
                res.setText(Float.toString(result));
                break;
            case R.id.div:
                result = numb1 / numb2;
                res.setText(Float.toString(result));
                break;
        }
    }
}
