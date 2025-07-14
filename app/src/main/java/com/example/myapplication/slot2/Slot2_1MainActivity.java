package com.example.myapplication.slot2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Slot2_1MainActivity extends AppCompatActivity {

    EditText txt1,txt2;
    Button btn1;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slot21_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // anh xa cac control
        txt1 = findViewById(R.id.sothunhat);
        txt2 = findViewById(R.id.sothuhai);
        btn1= findViewById(R.id.button);
        tv1=findViewById(R.id.textView);
        //xu ly su kien click button
        btn1.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(txt1.getText().toString());
                double b = Double.parseDouble(txt2.getText().toString());
                double tong = a + b;
                tv1.setText(String.valueOf(tong));
                Intent intent = new Intent(this,slot2_2MainActivity.class);
                intent.putExtra("tongman2",tong);
                startActivity(intent);
            } catch (NumberFormatException e) {
                tv1.setText("Vui lòng nhập số hợp lệ");
            }
        });
    }
}