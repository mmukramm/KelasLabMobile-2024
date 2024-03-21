package com.example.pekan2_pm_d;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Mahasiwa implements Parcelable {
    private String nama;
    private String nim;
    private String prodi;

    public Mahasiwa(String nama, String nim, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
    }

    protected Mahasiwa(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        prodi = in.readString();
    }

    public static final Creator<Mahasiwa> CREATOR = new Creator<Mahasiwa>() {
        @Override
        public Mahasiwa createFromParcel(Parcel in) {
            return new Mahasiwa(in);
        }

        @Override
        public Mahasiwa[] newArray(int size) {
            return new Mahasiwa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nim);
        parcel.writeString(prodi);
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getProdi() {
        return prodi;
    }
}
