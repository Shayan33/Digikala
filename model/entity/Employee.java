package model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "employee")
@Table(name = "EMPLOYEE")

public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employeeSeq")
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "EmployeeFirstName", columnDefinition = "VARCHAR2(33)")
    private String eFName;

    @Column(name = "EmployeeLastName", columnDefinition = "VARCHAR2(33)")
    private String eLName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String geteFName() {
        return eFName;
    }

    public void seteFName(String eFName) {
        this.eFName = eFName;
    }

    public String geteLName() {
        return eLName;
    }

    public void seteLName(String eLName) {
        this.eLName = eLName;
    }
}
