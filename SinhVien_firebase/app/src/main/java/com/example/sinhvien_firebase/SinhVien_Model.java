package com.example.sinhvien_firebase;

public class SinhVien_Model {
    String hoTen, maSV, lop;
    SinhVien_Model(){

    }

    public SinhVien_Model(String hoTen, String maSV, String lop) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.lop = lop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
