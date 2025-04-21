package com.valentin.wantsome.budget.webcontrollers;

import com.valentin.wantsome.budget.domain_dao.Income;
import com.valentin.wantsome.budget.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/incomes")
    public String incomes(Model model) {
        model.addAttribute("incomes", incomeService.findALl());
        return "incomes";
    }

    @GetMapping("/incomeForm")
    public String incomeForm(Model model) {
        model.addAttribute("income", new Income());
        return "incomeForm";
    }

    @PostMapping("/submitIncome")
    public String saveIncome(@ModelAttribute Income income, Model model) {
        incomeService.saveIncome(income);

        model.addAttribute("title", "Incomes");
        model.addAttribute("incomes", incomeService.findALl());
        return "incomes";
    }
}
