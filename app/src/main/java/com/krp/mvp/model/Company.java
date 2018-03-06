package com.krp.mvp.model;

/**
 * Created by rakeshpraneeth on 3/5/18.
 * This class describes the Company object.
 * Each variable in the class is a field that describes about the company.
 * The getter and setter methods are used to get and set the data with Api
 */

public class Company {

    private String name;
    private String catchPhrase;
    private String bs;

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

}