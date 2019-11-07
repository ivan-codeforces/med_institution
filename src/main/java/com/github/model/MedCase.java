package com.github.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CASES")
public class MedCase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NU")
    private String numberOfCase;
    private Date dateOfStart;
    private Date dateOfEnd;
    private String status;

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
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                ", status='" + status + '\'' +
                '}';
    }
}
