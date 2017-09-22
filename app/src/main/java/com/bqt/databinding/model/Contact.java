package com.bqt.databinding.model;

public class Contact {
    private final String mTel;
    private final String mAddress;

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
