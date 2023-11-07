package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class EstateController {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;


    @GetMapping(value = "/estates")
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getAllEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);
    }

    @PostMapping(value = "/estates")
    public ResponseEntity<Estate> addEstate(@RequestBody Estate estate){
        estateService.saveEstate(estate);
        return new ResponseEntity<>(estate,HttpStatus.OK);
    }


}
