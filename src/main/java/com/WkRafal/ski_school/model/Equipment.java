package com.WkRafal.ski_school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipmentID;

    private String equipmentType;

    private String brand;

    private String length;

    private String stateOfPossession;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;

    private String comments;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("equipment-rental")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("equipment-equipment_service")
    private List<EquipmentService> services;


    public Equipment() {
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int id) {
        this.equipmentID = id;
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

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<EquipmentService> getServices() {
        return services;
    }

    public void setServices(List<EquipmentService> services) {
        this.services = services;
    }

    public void updateFrom(final Equipment source) {
        pricePerDay = source.pricePerDay;
        comments = source.comments;
    }
}
