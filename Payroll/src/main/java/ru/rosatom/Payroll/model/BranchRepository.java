package ru.rosatom.Payroll.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    //List<Step> findByEmpId(Employee empId);
}