package ru.rosatom.Payroll.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findByEmpId(Employee empId);
}
