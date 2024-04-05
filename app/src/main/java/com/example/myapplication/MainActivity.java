package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button[] cal_btn=new Button[4];
    TextView textRet;
    String num1,num2;
    Integer ret;
    Button[] num_btn=new Button[10];
    Integer[] num_btn_id={R.id.Btn0,R.id.Btn1,R.id.Btn2,R.id.Btn3,R.id.Btn4,R.id.Btn5,R.id.Btn6,R.id.Btn7,R.id.Btn8,R.id.Btn9};
    int i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        textRet=findViewById(R.id.TextRet);

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        cal_btn[0] = findViewById(R.id.BtnAdd);
        cal_btn[1] = findViewById(R.id.BtnMinus);
        cal_btn[2] = findViewById(R.id.BtnMul);
        cal_btn[3] = findViewById(R.id.BtnDiv);


        for (i = 0; i < num_btn_id.length; i++) {
            num_btn[i] = findViewById(num_btn_id[i]);
        }
        for (i = 0; i < num_btn_id.length; i++) {
            final int index;
            index = i;

            num_btn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                        num1 = edit1.getText().toString() + num_btn[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString() + num_btn[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "텍스트 입력", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


        cal_btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                ret = Integer.parseInt(num1) + Integer.parseInt(num2);
                textRet.setText("계산 결과 : " + ret.toString());
            }
        });

        cal_btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                ret = Integer.parseInt(num1) - Integer.parseInt(num2);
                textRet.setText("계산 결과 : " + ret.toString());
            }
        });

        cal_btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                ret = Integer.parseInt(num1) * Integer.parseInt(num2);
                textRet.setText("계산 결과 : " + ret.toString());
            }
        });

        cal_btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                int secondNum = Integer.parseInt(num2);
                if (secondNum == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                ret = Integer.parseInt(num1) / secondNum;
                textRet.setText("계산 결과 : " + ret.toString());
            }
        });
    }
}