package com.ankit.controller;

import com.ankit.domain.Income;
import com.ankit.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by ankit07 on 9/2/16.
 */
@RestController
@Configuration
@ComponentScan(basePackages = "com.ankit.service")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @RequestMapping(value = "/income/",method = RequestMethod.GET)
    public ResponseEntity<List<Income>> listIncomes(){
        List<Income> incomes = incomeService.findAllIncomes();
        if( incomes.isEmpty()){
            return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Income>>(incomes,HttpStatus.OK);
    }

    @RequestMapping(value = "/income/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Income>    getUser(@PathVariable ("id") Long id){
        Income income = incomeService.findById(id);
        if( income == null){
            return new ResponseEntity<Income>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Income>(income,HttpStatus.OK);
    }

    @RequestMapping(value = "/income    /",method = RequestMethod.POST)
    public ResponseEntity<Void> createIncome(@RequestBody Income income, UriComponentsBuilder ucBuilder){
        System.out.println("New Income::: Year::" + income.getYear() + "\nMonth::" + income.getMonth());

        if( (incomeService.findAllByYear(income.getYear()) != null) && (incomeService.findAllByMonth(income.getMonth()) != null) ){
            System.out.println("Income Already Exists for Year::" + income.getYear() + " Month::" + income.getMonth());
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        incomeService.save(income);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/income/{id}").buildAndExpand(income.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }
}
