package ru.rosatom.Payroll.Controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.rosatom.Payroll.model.Employee;
import ru.rosatom.Payroll.model.Step;
import ru.rosatom.Payroll.model.StepRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@RestController
public class StepController {

    private static StepRepository repository;
    private static StepModelAssembler assembler;

    StepController(StepRepository repository, StepModelAssembler assembler) {
        StepController.repository = repository;
        StepController.assembler = assembler;
    }

    @GetMapping("/employees/step/{id}")
    EntityModel<Step> one(@PathVariable Long id) {

        Step step = repository.findById(id) //
                .orElseThrow(() -> new StepNotFoundException(id));

        return assembler.toModel(step);
    }

    @GetMapping("/employees/steps")
    CollectionModel<EntityModel<Step>> all() {

        List<EntityModel<Step>> steps = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(steps, linkTo(methodOn(StepController.class).all()).withSelfRel());
    }

    static CollectionModel<EntityModel<Step>> oneForEmployeeStep(Employee id) {

        List<EntityModel<Step>> step = repository.findByEmpId(id).stream().map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(step, linkTo(methodOn(StepController.class).all()).withSelfRel());
    }
}
