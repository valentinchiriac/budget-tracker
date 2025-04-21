package com.valentin.wantsome.budget.service;

import com.valentin.wantsome.budget.domain_dao.Income;
import com.valentin.wantsome.budget.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    private IncomeRepository incomeRepository;

    public void IncomeRepository(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> findALl(){
        return incomeRepository.findALl();
    }

    public void saveIncome(Income income) {
        incomeRepository.save(income);
    }
}
