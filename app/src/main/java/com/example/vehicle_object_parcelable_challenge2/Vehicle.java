package com.example.vehicle_object_parcelable_challenge2;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {
    private String make;
    private String color;
    private int num_of_doors;

    public Vehicle(String make, String color, int num_of_doors) {
        this.make = make;
        this.color = color;
        this.num_of_doors = num_of_doors;
    }

    protected Vehicle(Parcel in) {
        make = in.readString();
        color = in.readString();
        num_of_doors = in.readInt();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum_of_doors() {
        return num_of_doors;
    }

    public void setNum_of_doors(int num_of_doors) {
        this.num_of_doors = num_of_doors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(make);
        parcel.writeString(color);
        parcel.writeInt(num_of_doors);
    }
}
