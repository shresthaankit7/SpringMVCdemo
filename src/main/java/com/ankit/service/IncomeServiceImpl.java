package com.ankit.service;

import com.ankit.domain.Income;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ankit07 on 9/2/16.
 */
@Service("incomeService")
@Transactional
public class IncomeServiceImpl implements IncomeService {

    private static final AtomicLong counter = new AtomicLong();
    private static List<Income> incomes;

    static {
        incomes = populateDummyIncomes();
    }

    private static List<Income> populateDummyIncomes() {
        List<Income> incomes = new ArrayList<Income>();
        incomes.add(new Income("2015","12",8000,"Fox Digital Web"));
        incomes.add(new Income("2016","01",12000,"Deerwalk Inc."));
        incomes.add(new Income("2016","02",14000,"Deerwalk Inc."));
        return incomes;
    }

    @Override
    public Income findById(long id) {
        for(Income income: incomes){
            if(income.getId() == id){
                return income;
            }
        }
        return null;
    }

    @Override
    public List<Income> findAllIncomes() {
        return incomes;
    }
}
