package model.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity (name = "product")
@Table (name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "PRODUCT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "productSeq")
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "ProductName", columnDefinition = "VARCHAR2(133)")
    private String pName;

    @Column(name = "ProductCategoryCode", columnDefinition = "VARCHAR2(133)")
    private String pCatCode;

    @Column(name = "ProductAvatar", columnDefinition = "VARCHAR2(133)")
    private String pAvatar;

    @Column(name = "Available", columnDefinition = "VARCHAR2(33)")
    private String available;

    @Column(name = "Price", columnDefinition = "VARCHAR2(33)")
    private String price;

    @Column(name = "Wqty", columnDefinition = "VARCHAR2(33)")
    private String wqty;

    @Column(name = "Cqty", columnDefinition = "VARCHAR2(33)")
    private String cqty;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "WAREHOUSE_ID")
    private Warehouse warehouse;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCqty() {
        return cqty;
    }

    public void setCqty(String cqty) {
        this.cqty = cqty;
    }

    public String getWqty() {
        return wqty;
    }

    public void setWqty(String wqty) {
        this.wqty = wqty;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //private Sets<Category> categories;

    public String getpCatCode() {
        return pCatCode;
    }

    public void setpCatCode(String pCatCode) {
        this.pCatCode = pCatCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAvatar() {
        return pAvatar;
    }

    public void setpAvatar(String pAvatar) {
        this.pAvatar = pAvatar;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String availble) {
        this.available = availble;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
