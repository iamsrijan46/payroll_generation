package com.example.generation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String status; // PRESENT, ABSENT, HOLIDAY

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Attendance() {}

    public Attendance(LocalDate date, String status, User user) {
        this.date = date;
        this.status = status;
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
