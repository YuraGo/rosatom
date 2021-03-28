package ru.rosatom.Payroll.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Step {
    private @Id @GeneratedValue Long id;
    private String name;
    private int branch;
    @OneToOne
    @JoinColumn
    private Employee empId;

    public Step() {}

    public Step(String name, int branch, Employee empId) {
        this.name = name;
        this.branch = branch;
        this.empId = empId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }
}
