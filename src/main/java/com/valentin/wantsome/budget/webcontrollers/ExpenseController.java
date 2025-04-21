package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {this.expenseService = expenseService;}

    @GetMapping("/expenses")
    public String expense(Model model){
        model.addAttribute("expenses", expenseService.findALl());
        return "expenses";
    }


}
