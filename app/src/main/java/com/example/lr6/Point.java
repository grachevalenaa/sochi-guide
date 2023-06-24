package com.example.lr6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Point implements Parcelable {
    String name;
    String info;

    TypeOfSight typeOfSight;

    private com.yandex.mapkit.geometry.Point point;

    private String cost;

    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Point() {
    }

    public Point(com.yandex.mapkit.geometry.Point point, String info, String name, String cost, String time, TypeOfSight typeOfSight) {
        this.name = name;
        this.info = info;
        this.point = point;
        this.cost = cost;
        this.time = time;
        this.typeOfSight = typeOfSight;
    }

    protected Point(Parcel in) {
        info = in.readString();
        name = in.readString();
        point = new com.yandex.mapkit.geometry.Point(in.readDouble(), in.readDouble());
        cost = in.readString();
        time = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(info);
        dest.writeString(name);
        dest.writeDouble(point.getLatitude());
        dest.writeDouble(point.getLongitude());
        dest.writeString(cost);
        dest.writeString(time);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Point createFromParcel(Parcel in) {
            return new Point(in);
        }

        public Point[] newArray(int size) {
            return new Point[size];
        }
    };

    public com.yandex.mapkit.geometry.Point getPoint() {
        return point;
    }

    public void setPoint(com.yandex.mapkit.geometry.Point point) {
        this.point = point;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
