package com.ankit.service;

import com.ankit.domain.Income;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = "com.ankit.service")
public class IncomeServiceImpl implements IncomeService {

    private static final AtomicLong counter = new AtomicLong();
    private static List<Income> incomes;

    static {
        incomes = populateDummyIncomes();
    }

    private static List<Income> populateDummyIncomes() {
        List<Income> incomes = new ArrayList<Income>();
        incomes.add(new Income(counter.incrementAndGet(),"2015","12",8000,"Fox Digital Web"));
        incomes.add(new Income(counter.incrementAndGet(),"2016","01",12000,"Deerwalk Inc."));
        incomes.add(new Income(counter.incrementAndGet(),"2016","02",14000,"Deerwalk Inc."));
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

    @Override
    public Boolean isIncomeExists(Income income) {
        return null;
    }

    @Override
    public List<Income> findAllByYear(String year) {
        List<Income> incomeList = new ArrayList<Income>();
        for(Income i: incomes){
            if(i.getYear().equalsIgnoreCase(year)){
                incomeList.add(i);
            }
        }
        return incomeList;
    }

    @Override
    public List<Income> findAllByMonth(String month) {
        List<Income> incomeList = new ArrayList<Income>();
        for(Income i: incomes){
            if( i.getMonth().equalsIgnoreCase(month)){
                incomeList.add(i);
            }
        }
        return incomeList;
    }

    @Override
    public void save(Income income) {
        income.setId(counter.incrementAndGet());
        incomes.add(income);
    }
}
