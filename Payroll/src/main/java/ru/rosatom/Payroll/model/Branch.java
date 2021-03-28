package ru.rosatom.Payroll.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Branch {
    private @Id @GeneratedValue Long branchId;
    private String branchName;
    private int item; 
    @OneToOne
    @JoinColumn
    private Step stepId;

    public Branch(){}

    public Branch(String branchName, Step stepId) {
        this.branchName = branchName;
        this.stepId = stepId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Step getStepId() {
        return stepId;
    }

    public void setStepId(Step stepId) {
        this.stepId = stepId;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", item=" + item +
                ", stepId=" + stepId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId) && Objects.equals(branchName, branch.branchName) && Objects.equals(stepId, branch.stepId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, stepId);
    }
}
