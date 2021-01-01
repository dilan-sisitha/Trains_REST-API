package com.example.REST.API;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class TrainsAdmin {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private int id;

        @Column(name = "admin_name")
        private String admin_name;

        @Column(name = "password")
        private String password;
}
