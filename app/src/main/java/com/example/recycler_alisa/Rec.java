package com.example.recycler_alisa;

import android.os.Parcel;
import android.os.Parcelable;

public class Rec implements Parcelable {
     private String slovo;

    public String getSlovo() {

        return slovo;
    }

    public void setSlovo(String slovo) {

        this.slovo = slovo;
    }

    protected Rec(Parcel in) {
    }

    public Rec(String slovo) {

        this.slovo = slovo;
    }

    public static final Creator<Rec> CREATOR = new Creator<Rec>() {
        @Override
        public Rec createFromParcel(Parcel in) {
            return new Rec(in);
        }

        @Override
        public Rec[] newArray(int size) {
            return new Rec[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
