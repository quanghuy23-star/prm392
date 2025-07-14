package com.example.myapplication.slot4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Slot4BaseAdapter extends BaseAdapter {
    private Context context;
    private List<Slot4Student> list;

    public Slot4BaseAdapter(Context context, List<Slot4Student> list) {
        this.context = context;
        this.list = list;
    }

    //tinh tong so item
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // tao view + chuyen du lieu vao view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       //1 tao view
        Slot4ViewHolder holder;
  if(convertView==null)// neu chua ton tai view thi ta tao view moi
  {
      //tao block view
      convertView = LayoutInflater.from(context).inflate(R.layout.slot4_item_view,parent,false);
      // anh xa cac thanh phan cua itemview
      holder = new Slot4ViewHolder();
      holder.img_hinh = convertView.findViewById(R.id.slot4_itemview_img);
      holder.tvTen=convertView.findViewById(R.id.slot4_itemview_txtTen);
      holder.tvTuoi=convertView.findViewById(R.id.slot4_itemview_txtTuoi);
      //tao 1 temolate de lan sau su dung
      convertView.setTag(holder);
  }else{
      holder = (Slot4ViewHolder) convertView.getTag();
  }
        //2 gan du lieu cho view
        Slot4Student student = list.get(position);//lay 1 object va dua doi tuong student
        //gan du lieu cho cac truong
        holder.img_hinh.setImageResource(student.getHinh());
        holder.tvTen.setText(student.getTen());
        holder.tvTuoi.setText(student.getTuoi());
        return convertView;
    }
    //Tao lop lien ket voi layout ItemView
    static class Slot4ViewHolder{
        ImageView img_hinh;
        TextView tvTen,tvTuoi;
    }
}
