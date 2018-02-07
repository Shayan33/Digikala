
package model.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity (name = "category")
@Table (name = "CATEGORY")
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "categorySeq", sequenceName = "CATEGORY_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "categorySeq")
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "CategoryName", columnDefinition = "VARCHAR2(133)")
    private String catName;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}



