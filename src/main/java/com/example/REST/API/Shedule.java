package com.example.REST.API;

import javax.persistence.*;

@Entity
@Table(name = "shedule")
public class Shedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "refno")
    private String refno;

    @Column(name = "station")
    private String station;

    @Column(name = "sub_station")
    private String sub_station;


    @Column(name = "arrival")
    private String arrival;

    @Column(name = "departure")
    private String departure;

    @Column(name = "park")
    private String park;

    @Column(name = "crossing")
    private String crossing;

    @Column(name = "pt")
    private String pt;

    @Column(name = "other")
    private String other;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getSub_station() {
        return sub_station;
    }

    public void setSub_station(String sub_station) {
        this.sub_station = sub_station;
    }
}
