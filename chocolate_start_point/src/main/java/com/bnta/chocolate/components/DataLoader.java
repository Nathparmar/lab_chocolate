package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    public void run(ApplicationArguments args){
        Estate estate1 = new Estate("choco1", "Madagascar");
        Estate estate2 = new Estate("choco2", "Sierra Leone");

       estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);

        Chocolate chocolate1 = new Chocolate("Galaxy", 50, estate1);
        Chocolate chocolate2 = new Chocolate("Dark", 70, estate2);


        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);

    }

}
