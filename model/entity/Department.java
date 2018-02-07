package model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "department")
@Table(name = "DEPARTMENT")

public class Department implements Serializable {

    @Id
    @SequenceGenerator(name = "departmentSeq", sequenceName = "DEPARTMENT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "departmentSeq")
    @Column(name = "DEPARTMENT_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "DepartmentName", columnDefinition = "VARCHAR2(33)")
    private String dName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
