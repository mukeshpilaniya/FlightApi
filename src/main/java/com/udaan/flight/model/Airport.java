package com.udaan.flight.model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private long id;

    @Column(name = "airport_name")
    private String name;

    @Column(name = "airport_code")
    private String code;

    @Column(name = "airport_city")
    private String city;

    public Airport(){

    }

    public Airport(String name, String city, String code){
        this.name=name;
        this.city=city;
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
