package com.github.bo;

import com.github.model.PatientEntity;
import com.github.model.User;

import java.util.Date;

public class CaseBo {

    private String id;

    private Date dateOfStart;

    private Date dateOfEnd;

    private String status;

    private User ownerU;

    private PatientEntity ownerP;

    public PatientEntity getOwnerP() {
        return ownerP;
    }

    public void setOwnerP(PatientEntity ownerP) {
        this.ownerP = ownerP;
    }

    public User getOwnerU() {
        return ownerU;
    }

    public void setOwnerU(User ownerU) {
        this.ownerU = ownerU;
    }

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
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
