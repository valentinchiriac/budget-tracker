package com.valentin.wantsome.budget.repository;

import com.valentin.wantsome.budget.domain_dao.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findByExpenseId (Long Id);
}