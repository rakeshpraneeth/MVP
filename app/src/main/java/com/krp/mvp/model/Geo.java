package com.krp.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This class describes the Geo object.
 * Each variable in the class is a field that describes about the Geographical location.
 * The getter and setter methods are used to get and set the data with Api
 */

public class Geo implements Parcelable {

    private Double lat;
    private Double lng;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.lat);
        dest.writeValue(this.lng);
    }

    public Geo() {
    }

    protected Geo(Parcel in) {
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Geo> CREATOR = new Parcelable.Creator<Geo>() {
        @Override
        public Geo createFromParcel(Parcel source) {
            return new Geo(source);
        }

        @Override
        public Geo[] newArray(int size) {
            return new Geo[size];
        }
    };
}
