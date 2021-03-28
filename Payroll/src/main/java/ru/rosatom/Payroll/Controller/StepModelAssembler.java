package ru.rosatom.Payroll.Controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ru.rosatom.Payroll.model.Step;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StepModelAssembler implements RepresentationModelAssembler<Step, EntityModel<Step>> {
    @Override
    public EntityModel<Step> toModel(Step step) {

        return EntityModel.of(step, //
                linkTo(methodOn(StepController.class).one(step.getId())).withSelfRel(),
                linkTo(methodOn(StepController.class).all()).withRel("steps"));
    }
}



