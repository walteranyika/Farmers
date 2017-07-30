package io.farmers.farmers.models;

/**
 * Created by walter on 7/30/17.
 */

public class Dealer {
    String name;
    String location;
    String phone;
    String speciality;
    double longitude;
    double latitude;

    public Dealer() {
    }

    public Dealer(String name, String location, String phone, String speciality, double longitude, double latitude) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.speciality = speciality;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
