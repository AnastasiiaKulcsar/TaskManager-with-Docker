package com.example.taskmanager.entity;


import jakarta.persistence.*;


@Entity
@Table(name="tbl_expense")
public class Expense {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private double price;

    private String imageName;

    public Expense() {
    }

    public Expense(Long id, double price, String imageName) {
        this.id = id;
        this.price = price;
        this.imageName = imageName;
    }

    public Expense(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
