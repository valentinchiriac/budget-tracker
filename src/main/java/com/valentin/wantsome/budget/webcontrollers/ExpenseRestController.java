package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.domain_dao.ExpenseCategory;
import com.valentin.wantsome.budget.service.ExpenseCategoryService;
import com.valentin.wantsome.budget.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ExpenseRestController {
    private final ExpenseService expenseService;
    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseRestController(ExpenseService expenseService, ExpenseCategoryService expenseCategoryService) {this.expenseService = expenseService;
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping("/expenses")
    public  List<Expense> expense(){
        List<Expense> expenses = expenseService.findAll();
        return expenses;
    }

    @GetMapping("/expenseForm")
    public String expenseForm(Model model) {
        List<ExpenseCategory> categories = expenseCategoryService.findAll();

        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", categories);
        return "expenseForm";
    }

    @PostMapping("/submitExpense")
    public String saveExpense(@ModelAttribute Expense expense, Model model) {
        expenseService.save(expense);
        model.addAttribute("title", "Expenses");
        model.addAttribute("expenses", expenseService.findAll());
        return "redirect:/expenses";
    }
}
