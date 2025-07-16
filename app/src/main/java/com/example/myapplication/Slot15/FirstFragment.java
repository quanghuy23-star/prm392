package com.example.myapplication.slot15;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private Button btnPopup;
    private TextView tvContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btnPopup = view.findViewById(R.id.btnPopup);
        tvContext = view.findViewById(R.id.tvContext);

        // Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getContext(), btnPopup);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(getContext(), "Chọn: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            popup.show();
        });

        // Context Menu
        registerForContextMenu(tvContext);

        return view;
    }

    // Context Menu xử lý
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.tvContext) {
            menu.setHeaderTitle("Chọn hành động");
            menu.add(0, v.getId(), 0, "Sao chép");
            menu.add(0, v.getId(), 1, "Xóa");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(getContext(), "Bạn chọn: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
