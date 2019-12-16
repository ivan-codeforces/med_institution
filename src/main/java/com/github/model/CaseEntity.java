package com.github.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cases")
public class CaseEntity {

    @Id
    @Column(name = "NUMBER")
    private String id;

    @Column(name = "START_DATE")
    private Date dateOfStart;

    @Column(name = "FINISH_DATE")
    private Date dateOfEnd;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_DOCTOR")
    private UserEntity ownerU;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CURRENT_PATIENT")
    private PatientEntity ownerP;

    public PatientEntity getOwnerP() {
        return ownerP;
    }

    public void setOwnerP(PatientEntity ownerP) {
        this.ownerP = ownerP;
    }

    public UserEntity getOwnerU() {
        return ownerU;
    }

    public void setOwnerU(UserEntity ownerU) {
        this.ownerU = ownerU;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

}