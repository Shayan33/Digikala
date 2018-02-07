package model.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity (name = "address")
@Table (name = "ADDRESS")
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "ADDRESS_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "addressSeq")
    @Column(name = "ADDRESS_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "Address", columnDefinition = "VARCHAR2(133)")
    private String address;



   @ManyToMany(cascade = CascadeType.ALL, mappedBy = "addresses")

   private Set<Customer> customers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}


