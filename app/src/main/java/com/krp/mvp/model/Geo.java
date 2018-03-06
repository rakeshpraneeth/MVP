package com.krp.mvp.model;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This class describes the Geo object.
 * Each variable in the class is a field that describes about the Geographical location.
 * The getter and setter methods are used to get and set the data with Api
 */

public class Geo {

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
}
