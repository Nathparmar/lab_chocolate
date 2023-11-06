package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
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
    @GetMapping (value = "/chocs")
    public ResponseEntity<List<Chocolate>> getAllChocs(){
        List<Chocolate> chocolates = chocolateService.getAllChocs();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

}
