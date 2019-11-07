package com.github.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CASES")
public class Case {

    @Id
    @Column(name = "CASE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CASE_NUMBER")
    private String numberOfCase;

    @Column(name = "CASE_START_DATE")
    private Date dateOfStart;

    @Column(name = "CASE_FINISH_DATE")
    private Date dateOfEnd;

    @Column(name = "CASE_STATUS")
    private String status;

//    @OneToMany(targetEntity = Doctor.class)
//    @Column
//    private Doctor doctor;

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
        return "MedCase{" +
                "id=" + id +
                ", numberOfCase='" + numberOfCase + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
