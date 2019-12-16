package com.github.model;

public enum CaseStatus {
    INITIAL("INITIAL"),
    IN_PROGRESS("IN PROGRESS"),
    FINALIZED("FINALIZED"),
    REOPENED("REOPENED");

    private String text;

    CaseStatus(String str){
        this.text=str;
    }

    public String getText() {
        return text;
    }
}
