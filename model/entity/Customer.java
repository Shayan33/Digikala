package model.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity (name = "customer")
@Table (name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "CUSTOMER_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSeq")
    @Column(name = "CUSTOMER_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "CustomerFirstName", columnDefinition = "VARCHAR2(33)")
    private String cFName;

    @Column(name = "CustomerLastName", columnDefinition = "VARCHAR2(33)")
    private String cLName;

    @Column(name = "Username", columnDefinition = "VARCHAR2(33)")
    private String cUName;

    @Column(name = "Password", columnDefinition = "VARCHAR2(33)")
    private String cPass;

    @Column(name = "Email", columnDefinition = "VARCHAR2(33)")
    private String cMail;

    @Column(name = "ImageDirectory", columnDefinition = "VARCHAR2(33)")
    private String cAvatar;

    @Column(name = "Gender", columnDefinition = "VARCHAR2(33)")
    private String cGender;

    @Column(name = "RegistrationDate", columnDefinition = "VARCHAR2(33)")
    private String cRDate;

    @Column(name = "Telephone", columnDefinition = "VARCHAR2(33)")
    private String cTele;

   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "CA",
            joinColumns = {@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")})


    public Set<Address> addresses;

    public String getcUName() {
        return cUName;
    }

    public void setcUName(String cUName) {
        this.cUName = cUName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getcFName() {
        return cFName;
    }

    public void setcFName(String cFName) {
        this.cFName = cFName;
    }

    public String getcLName() {
        return cLName;
    }

    public void setcLName(String cLName) {
        this.cLName = cLName;
    }

    public String getcPass() {
        return cPass;
    }

    public void setcPass(String cPass) {
        this.cPass = cPass;
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail;
    }

    public String getcAvatar() {
        return cAvatar;
    }

    public void setcAvatar(String cAvatar) {
        this.cAvatar = cAvatar;
    }

    public String getcGender() {
        return cGender;
    }

    public void setcGender(String cGender) {
        this.cGender = cGender;
    }

    public String getcRDate() {
        return cRDate;
    }

    public void setcRDate(String cRDate) {
        this.cRDate = cRDate;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele;
    }

}





