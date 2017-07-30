package io.farmers.farmers.models;

/**
 * Created by walter on 7/30/17.
 */

public class Farmer {
    String names;
    String phone;
    String location;
    String proffession;
    double latitude;
    double longitude;
    public Farmer() {
    }

    public Farmer(String names, String phone, String location, String proffession, double latitude, double longitude) {
        this.names = names;
        this.phone = phone;
        this.location = location;
        this.proffession = proffession;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProffession() {
        return proffession;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
    }
}
