package ru.rosatom.Payroll.Controller;


class StepNotFoundException extends RuntimeException {
    StepNotFoundException(Long id) {
        super("Could not find step " + id);
    }
}