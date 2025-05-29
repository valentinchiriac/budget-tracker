package com.valentin.wantsome.budget.repository;

import com.valentin.wantsome.budget.domain_dao.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<Expense> findById (Long Id);
}