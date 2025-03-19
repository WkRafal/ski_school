package com.WkRafal.ski_school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "equipment_services")
public class EquipmentService {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int equipmentSerwisID;

        @ManyToOne
        @JoinColumn(name = "equipmentID", nullable = false)
        @JsonBackReference("equipment-equipment_service")
        private Equipment equipment;

        @ManyToOne
        @JoinColumn(name = "userID", nullable = false)
        @JsonBackReference("user-equipment_service")
        private User user;

        @Column(nullable = false)
        private LocalDate serviceDate;

        private String description;

        private BigDecimal price;

    public EquipmentService() {
    }

    public int getEquipmentSerwisID() {
        return equipmentSerwisID;
    }

    public void setEquipmentSerwisID(int equipmentSerwisID) {
        this.equipmentSerwisID = equipmentSerwisID;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String opis) {
        this.description = opis;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal koszt) {
        this.price = koszt;
    }
}
