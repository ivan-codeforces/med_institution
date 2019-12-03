package com.github.model;

import javax.persistence.Entity;

//@Entity
public enum CaseStatus {
    INITIAL("INITIAL"),
    IN_PROGRESS("IN PROGRESS"),
    FINALIZED("FINALIZED");

    private String text;

    CaseStatus(String str){
        this.text=str;
    }

    public String getText() {
        return text;
    }
}
