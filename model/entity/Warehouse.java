package model.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity (name = "warehouse")
@Table (name = "WAREHOUSE")
public class Warehouse implements Serializable {

    @Id
    @SequenceGenerator(name = "warehouseSeq", sequenceName = "WAREHOUSE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "warehouseSeq")
    @Column(name = "WAREHOUSE_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "WareHouseName", columnDefinition = "VARCHAR2(133)")
    private String wName;

    @Column(name = "WareHouseAddress", columnDefinition = "VARCHAR2(133)")
    private String wAddress;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getwAddress() {
        return wAddress;
    }

    public void setwAddress(String wAddress) {
        this.wAddress = wAddress;
    }


}

