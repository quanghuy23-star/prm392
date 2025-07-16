package com.example.myapplication.slot10;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;


public class Slot10_MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnAdd, btnDelete, btnShow;
    TextView txtOutput;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot10_main);

        edtName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnShow = findViewById(R.id.btnShow);
        txtOutput = findViewById(R.id.txtOutput);

        db = new DBHelper(this);

        btnAdd.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            if (db.insertUser(name)) {
                Toast.makeText(this, "Đã thêm: " + name, Toast.LENGTH_SHORT).show();
                edtName.setText("");
            } else {
                Toast.makeText(this, "Lỗi khi thêm!", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            if (db.deleteUser(name)) {
                Toast.makeText(this, "Đã xóa: " + name, Toast.LENGTH_SHORT).show();
                edtName.setText("");
            } else {
                Toast.makeText(this, "Không tìm thấy!", Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(v -> {
            Cursor c = db.getAllUsers();
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append(c.getInt(0)).append(". ").append(c.getString(1)).append("\n");
            }
            txtOutput.setText(sb.toString());
        });
    }
}
