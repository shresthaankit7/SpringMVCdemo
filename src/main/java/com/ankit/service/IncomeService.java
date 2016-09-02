package com.ankit.service;

import com.ankit.domain.Income;

import java.util.List;

/**
 * Created by ankit07 on 9/2/16.
 */
public interface IncomeService {

    Income findById(long id);

    List<Income> findAllIncomes();

}
