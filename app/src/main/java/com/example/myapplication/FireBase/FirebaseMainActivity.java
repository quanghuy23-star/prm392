package com.example.myapplication.firebase;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.*;

public class FirebaseMainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSave;
    TextView txtResult;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);

        edtName = findViewById(R.id.edtName);
        btnSave = findViewById(R.id.btnSave);
        txtResult = findViewById(R.id.txtResult);

        // Tham chiếu tới node "users" trong Realtime Database
        dbRef = FirebaseDatabase.getInstance().getReference("users");

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            if (!name.isEmpty()) {
                String id = dbRef.push().getKey();
                dbRef.child(id).setValue(name).addOnSuccessListener(unused ->
                        Toast.makeText(this, "Đã lưu", Toast.LENGTH_SHORT).show());
            }
        });

        // Lắng nghe dữ liệu thay đổi
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                StringBuilder builder = new StringBuilder();
                for (DataSnapshot child : snapshot.getChildren()) {
                    builder.append("- ").append(child.getValue(String.class)).append("\n");
                }
                txtResult.setText(builder.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                txtResult.setText("Lỗi: " + error.getMessage());
            }
        });
    }
}
