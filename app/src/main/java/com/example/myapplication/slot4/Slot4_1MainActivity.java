package com.example.myapplication.slot4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Slot4_1MainActivity extends AppCompatActivity {
ListView lv;
List<Slot4Student> list = new ArrayList<>();
Slot4BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slot41_main);

        lv =findViewById(R.id.slot4_1lv);
        //tao nguon du lieu
        list.add(new Slot4Student(R.drawable.android,"15","Nguyen Van An"));
        list.add(new Slot4Student(R.drawable.apple,"16","Nguyen Van An"));
        list.add(new Slot4Student(R.drawable.blogger,"17","Nguyen Van An"));
        list.add(new Slot4Student(R.drawable.hp,"18","Nguyen Van An"));
        list.add(new Slot4Student(R.drawable.dell,"19","Nguyen Van An"));
        list.add(new Slot4Student(R.drawable.facebook,"14","Nguyen Van An"));
        adapter = new Slot4BaseAdapter(this,list);
        lv.setAdapter(adapter);
    }
}