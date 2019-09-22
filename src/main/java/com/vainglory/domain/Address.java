package com.vainglory.domain;

public class Address {
    private Integer id;
    private String country;
    private String province;
    private String city;
    private Integer uid;

    public Address() {
    }

    public Address(Integer id, String country, String province, String city, Integer uid) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", uid=" + uid +
                '}';
    }
}
