package ru.rosatom.Payroll.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rosatom.Payroll.model.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, StepRepository stepRep, BranchRepository brRep, ItemRepository itRep) {


        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar", "87771234545", "bilbo@mail.com")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief", "87771239988", "frodo@mail.com")));

            log.info("Preloading" + stepRep.save(new Step("branch 1", 1, repository.findById(1L).orElse(new Employee()))));//3
            log.info("Preloading" + stepRep.save(new Step("branch 2", 2, repository.findById(1L).orElse(new Employee()))));//4
            log.info("Preloading" + stepRep.save(new Step("branch 3", 3, repository.findById(1L).orElse(new Employee()))));//5

            log.info("Preloading" + stepRep.save(new Step("branch 1", 1, repository.findById(2L).orElse(new Employee()))));//6
            log.info("Preloading" + stepRep.save(new Step("branch 2", 2, repository.findById(2L).orElse(new Employee()))));//7
            log.info("Preloading" + stepRep.save(new Step("branch 3", 3, repository.findById(2L).orElse(new Employee()))));//8

            log.info("Preloading" + brRep.save(new Branch("branchName 1.1", stepRep.findById(3L).orElse(new Step()))));//9
            log.info("Preloading" + brRep.save(new Branch("branchName 1.2", stepRep.findById(3L).orElse(new Step()))));//10

            log.info("Preloading" + brRep.save(new Branch("branchName 2", stepRep.findById(4L).orElse(new Step()))));//11

            log.info("Preloading" + brRep.save(new Branch("branchName 3", stepRep.findById(5L).orElse(new Step()))));//12

            log.info("Preloading" + brRep.save(new Branch("branchName 1.1", stepRep.findById(6L).orElse(new Step()))));//13
            log.info("Preloading" + brRep.save(new Branch("branchName 1.2", stepRep.findById(6L).orElse(new Step()))));//14

            log.info("Preloading" + brRep.save(new Branch("branchName 2", stepRep.findById(7L).orElse(new Step()))));//15

            log.info("Preloading" + brRep.save(new Branch("branchName 3", stepRep.findById(8L).orElse(new Step()))));//16

            log.info("Preloading" + itRep.save(new Item("name 1" , "discr1", false, brRep.findById(9L).orElse(new Branch()))));//17
            log.info("Preloading" + itRep.save(new Item("name 2" , "discr2", false, brRep.findById(9L).orElse(new Branch()))));//18
            log.info("Preloading" + itRep.save(new Item("name 3" , "discr3", false, brRep.findById(9L).orElse(new Branch()))));//19
            log.info("Preloading" + itRep.save(new Item("name 4" , "discr4", false, brRep.findById(9L).orElse(new Branch()))));//20
        };

    }
}

