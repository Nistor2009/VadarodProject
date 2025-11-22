package com.example.VadarodProject.entity;

import jakarta.persistence.Column;

public class Address {
    //город, улица, номер дома, почтовый индекс
    private String city;
    private String street;
    private String house;
    @Column(name = "post_index")
    private String postIndex;
}
