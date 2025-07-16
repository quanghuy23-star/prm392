package com.example.myapplication.slot14;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Slot14_MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSend;
    TextView txtResult;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot14_main);

        edtName = findViewById(R.id.edtName);
        btnSend = findViewById(R.id.btnSend);
        txtResult = findViewById(R.id.txtResult);

        requestQueue = Volley.newRequestQueue(this);

        btnSend.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
                return;
            }

            sendPostRequest(name);
        });
    }

    private void sendPostRequest(String name) {
        String url = "https://reqres.in/api/users"; // fake API test

        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                new JSONObject(params),
                response -> {
                    txtResult.setText("Phản hồi từ server:\n" + response.toString());
                    Toast.makeText(this, "Gửi thành công!", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    txtResult.setText("Lỗi: " + error.toString());
                    Toast.makeText(this, "Gửi thất bại", Toast.LENGTH_SHORT).show();
                }
        );

        requestQueue.add(jsonRequest);
    }
}
