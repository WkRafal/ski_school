package com.WkRafal.ski_school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    @JsonBackReference("user-rental")
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipmentID", nullable = false)
    @JsonBackReference("equipment-rental")
    private Equipment equipment;

    //@Column(name = "rental_date", nullable = false)
    private LocalDate rentalDate;

    //@Column(name = "planned_return", nullable = true)
    private LocalDate plannedReturn;

    //@Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    //@Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    //@Column(nullable = false)
    private String status;

    public Rental() {
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int id) {
        this.rentalID = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getPlannedReturn() {
        return plannedReturn;
    }

    public void setPlannedReturn(LocalDate plannedReturn) {
        this.plannedReturn = plannedReturn;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
