package com.example.REST.API;

import javax.persistence.*;

@Entity
@Table(name = "Train_Details")
public class TrainDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "refno")
    private String refno;

    @Column(name = "details")
    private String details;

    @Column(name = "form_no")
    private String form_no;

    @Column(name = "other")
    private String other;

    @Column(name = "info")
    private String info;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getForm_no() {
        return form_no;
    }

    public void setForm_no(String form_no) {
        this.form_no = form_no;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
