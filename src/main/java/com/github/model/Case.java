package com.github.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cases")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_PATIENT")
    private Patient ownerP;

    public Patient getOwnerP() {
        return ownerP;
    }

    public void setOwnerP(Patient ownerP) {
        this.ownerP = ownerP;
    }

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
                ", ownerP=" + ownerP +
                '}';
    }
}
