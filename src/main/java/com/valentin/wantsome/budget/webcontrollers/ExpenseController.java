package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.exception.NoExpenseException;
import com.valentin.wantsome.budget.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") // Adds a base path for endpoints
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = expenseService.findAll();
        if (expenses.isEmpty()) {
            throw new NoExpenseException("No expenses found.");
        }
        return expenses;
    }

    @PostMapping("/expense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @GetMapping("/expense/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @PutMapping("/expense/{id}")
    public ResponseEntity<String> updateExpense(@RequestBody Expense expense, @PathVariable Long id) {
        expenseService.updateExpense(expense, id);
        return ResponseEntity.ok("Expense updated successfully!");
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return ResponseEntity.ok("Expense deleted successfully!");
    }
}
