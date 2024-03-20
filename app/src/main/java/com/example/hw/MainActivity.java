package com.example.hw;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button[] btn= new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn[0]=findViewById(R.id.btn1);
        btn[0].setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com/"));
            startActivity(intent);
        });

        btn[1]=findViewById(R.id.btn2);
        btn[1].setOnClickListener(v -> {

            String tel="tel:01039005294";
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(tel));
            startActivity(intent);
        });

        btn[3]=findViewById(R.id.btn4);
        btn[3].setOnClickListener(v->{
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}