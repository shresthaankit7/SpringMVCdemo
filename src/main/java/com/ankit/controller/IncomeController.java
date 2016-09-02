package com.ankit.controller;

import com.ankit.domain.Income;
import com.ankit.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ankit07 on 9/2/16.
 */
@RestController
public class IncomeController {

//    @Autowired
//    IncomeService incomeService;
//
//    @RequestMapping(value = "/income/",method = RequestMethod.GET)
//    public ResponseEntity<List<Income>> listIncomes(){
//        List<Income> incomes = incomeService.findAllIncomes();
//        if( incomes.isEmpty()){
//            return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Income>>(incomes,HttpStatus.OK);
//    }
}
