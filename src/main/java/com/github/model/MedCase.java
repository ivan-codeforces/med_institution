package com.github.model;

import java.util.Date;

public class MedCase {
    private int id;
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
}
