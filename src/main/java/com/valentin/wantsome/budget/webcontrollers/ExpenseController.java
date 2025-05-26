package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.exception.NoExpenseException;
import com.valentin.wantsome.budget.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {this.expenseService = expenseService;}

//    @GetMapping("/expenses")
//    public String expense(Model model){
//        model.addAttribute("expenses", expenseService.findALl());
//        return "expenses";
//    }
//    @GetMapping("/expenseForm")
//    public String expenseForm(Model model) {
//        model.addAttribute("expense", new Expense());
//        return "expenseForm";
//    }
//
//    @PostMapping("/submitExpense")
//    public String saveExpense(@ModelAttribute Expense expense, Model model) {
//        expenseService.saveExpense(expense);
//
//        model.addAttribute("title", "Expenses");
//        model.addAttribute("expenses", expenseService.findALl());
//        return "expenses";
//    }
//}
@GetMapping("/expenses")
public List<Expense> getAllExpenses(){

    List<Expense> expenses =  expenseService.getExpense();

    if (expenses.isEmpty()) {
        System.out.println("No expenses are found");
        throw new NoExpenseException("No Expense exception");
    }
    return expenses;
}

    @PostMapping("/expense")
    public void addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
    }

    @GetMapping("/expense/{id}")
    public Optional<Expense> getExpense(@PathVariable int id){
        return expenseService.getExpense(id);
    }

    @PutMapping("/expense/{id}")
    public void updateExpense(@RequestBody Expense expense, @PathVariable int id){
        expenseService.updateExpense(expense, id);
    }

    @DeleteMapping("/expense/{id}")
    public void deleteExpenseById(@PathVariable int id){
        expenseService.deleteExpenseById(id);
    }

}
