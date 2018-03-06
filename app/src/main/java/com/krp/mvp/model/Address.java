package com.krp.mvp.model;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This class describes the Address object.
 * Each variable in the class is a field that describes about the Address.
 * The getter and setter methods are used to get and set the data with Api.
 */

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCompleteAddress(){

        return street+", "+suite+", "+city+", "+zipcode;
    }
}
