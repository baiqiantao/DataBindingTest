package com.bqt.databinding.model;

public class Contact {
    public String mTel;
    public String mAddress;

    public Contact(String tel, String address) {
        mTel = tel;
        mAddress = address;
    }

    public String getTel() {
        return mTel;
    }

    public String getAddress() {
        return mAddress;
    }
}
