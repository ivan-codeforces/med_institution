package com.github.bo;

import com.github.model.User;

import java.util.Date;

public class CaseBo {

    private int id;

    private String numberOfCase;

    private Date dateOfStart;

    private Date dateOfEnd;

    private String status;

    private User ownerU;

    public User getOwnerU() {
        return ownerU;
    }

    public void setOwnerU(User ownerU) {
        this.ownerU = ownerU;
    }

    public int getId() {
        return id;
    }

    public String getNumberOfCase() {
        return numberOfCase;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfCase(String numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
