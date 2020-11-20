package com.udaan.flight.model;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private long id;

    @Column(name = "station_name")
    private String name;

    @Column(name = "station_code")
    private String code;

    @Column(name = "station_city")
    private String city;

    public Station(){

    }

    public Station(String name, String city,String code){
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
