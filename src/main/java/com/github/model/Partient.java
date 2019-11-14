package com.github.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PATIENT")
public class Partient {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "PASSPORT")
    private int passport;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private int phone;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "SSN")
    private int ssn;

    @OneToMany(mappedBy = "ownerP", fetch = FetchType.EAGER)
    private Set<Case> case_id;

    public Set<Case> getCase_id() {
        return case_id;
    }

    public void setCase_id(Set<Case> case_id) {
        this.case_id = case_id;
    }

}
