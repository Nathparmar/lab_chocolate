package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateRepository estateRepository;
    @GetMapping (value = "/chocolates")
    public ResponseEntity<List<Chocolate>> getAllChocs(){
        List<Chocolate> chocolates = chocolateService.getAllChocs();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chocolate> addChocs(@RequestBody ChocolateDTO chocolateDTO){
        Estate estate = estateRepository.getById(chocolateDTO.getEstateId());
        Chocolate chocolate = new Chocolate(chocolateDTO.getName(),chocolateDTO.getCocoaPercentage(),estate);
        chocolateService.saveChocolate(chocolate);
        return new ResponseEntity<>(chocolate,HttpStatus.OK);
    }

    @PostMapping(value = "/coca/{percentage}")
    public ResponseEntity<List<Chocolate>> allChocosWithCocaPercentage(@PathVariable int percentage){
        return new ResponseEntity<>(chocolateService.minCocoaPercentageChocolate(percentage),HttpStatus.OK);
    }

}
