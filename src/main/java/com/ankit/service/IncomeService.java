package com.ankit.service;

import com.ankit.domain.Income;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by ankit07 on 9/2/16.
 */
public interface IncomeService {

    Income findById(long id);

    List<Income> findAllIncomes();

    Boolean isIncomeExists(Income income);

    List<Income> findAllByYear(String year);

    List<Income> findAllByMonth(String month);

    void save(Income income);
}
