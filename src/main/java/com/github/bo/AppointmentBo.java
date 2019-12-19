package com.github.bo;

import java.sql.Timestamp;

public class AppointmentBo {

    private int id;
    private String medCaseId;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedCaseId() {
        return medCaseId;
    }

    public void setMedCaseId(String medCaseId) {
        this.medCaseId = medCaseId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
