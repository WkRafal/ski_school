package com.WkRafal.ski_school.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String equipmentType;

    private String brand;

    private String length;

    private String stateOfPossession;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;

    private String comments;

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStateOfPossession() {
        return stateOfPossession;
    }

    public void setStateOfPossession(String stateOfPossession) {
        this.stateOfPossession = stateOfPossession;
    }

    public void updateFrom(final Equipment source) {
        pricePerDay = source.pricePerDay;
        comments = source.comments;
    }
}
