package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.domain_dao.ExpenseCategoryType;
import com.valentin.wantsome.budget.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {this.expenseService = expenseService;}

    @GetMapping("/expenses")
    public String expense(Model model){
        model.addAttribute("expenses", expenseService.findAll());
        return "expenses";
    }
    @GetMapping("/expenseForm")
    public String expenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", Arrays.asList(ExpenseCategoryType.values()));
        return "expenseForm";
    }

    @PostMapping("/submitExpense")
    public String saveExpense(@ModelAttribute Expense expense, Model model) {
        expenseService.saveExpense(expense);

        model.addAttribute("title", "Expenses");
        model.addAttribute("expenses", expenseService.findAll());
        return "expenses";
    }
}
