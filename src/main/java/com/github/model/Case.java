package com.github.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CASES")
public class Case {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMBER")
    private String numberOfCase;

    @Column(name = "START_DATE")
    private Date dateOfStart;

    @Column(name = "FINISH_DATE")
    private Date dateOfEnd;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_USER")
    private User ownerU;

    public Partient getOwnerP() {
        return ownerP;
    }

    public void setOwnerP(Partient ownerP) {
        this.ownerP = ownerP;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_PATIENT")
    private Partient ownerP;

    public User getOwnerU() {
        return ownerU;
    }

    public void setOwnerU(User ownerU) {
        this.ownerU = ownerU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberOfCase() {
        return numberOfCase;
    }

    public void setNumberOfCase(String numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", numberOfCase='" + numberOfCase + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                ", status='" + status + '\'' +
                ", ownerU=" + ownerU +
                '}';
    }
}
