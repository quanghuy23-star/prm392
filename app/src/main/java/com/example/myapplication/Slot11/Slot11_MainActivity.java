package com.example.myapplication.slot11;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Slot11_MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSend;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot11_main);

        edtName = findViewById(R.id.edtName);
        btnSend = findViewById(R.id.btnSend);

        apiService = ApiClient.getClient().create(ApiService.class);

        btnSend.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User(name);
            apiService.insertUser(user).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(Slot11_MainActivity.this, "Gửi thành công!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Slot11_MainActivity.this, "Lỗi gửi: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(Slot11_MainActivity.this, "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
