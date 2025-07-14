package com.example.myapplication.slot4;

public class Slot4Student {
private String ten;
private String tuoi;

private int hinh;

    public Slot4Student() {
    }

    public Slot4Student(int hinh, String tuoi, String ten) {
        this.hinh = hinh;
        this.tuoi = tuoi;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
