package com.noob.sportsdemo.entity;

public class Car {
    private String car_id;
    private String license;
    private String car_stat;

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCar_stat() {
        return car_stat;
    }

    public void setCar_stat(String car_stat) {
        this.car_stat = car_stat;
    }
    public String toString(){
        return "Car{" +
                "car_id=" + car_id + '\''+
                ", license=" + license + '\''+
                ", car_stat=" + car_stat + '\'' +
                '}';
    }
}
