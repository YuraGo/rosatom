package ru.rosatom.Payroll.model;

import javax.persistence.*;

@Entity
public class Item {
    private @Id @GeneratedValue Long itemId;
    private String itemName;
    private String text;
    private boolean done;
    @OneToOne
    @JoinColumn
    private Branch branchId;

    public Item(){}

    public Item(String itemName, String text, boolean done, Branch branchId) {
        this.itemName = itemName;
        this.text = text;
        this.done = done;
        this.branchId = branchId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }
}
