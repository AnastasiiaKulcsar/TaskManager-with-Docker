package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Expense;
import com.example.taskmanager.presistence.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/manageExpense")
    public String manageExpense(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        double sumOfPrices = expenses.stream()
                .mapToDouble(Expense::getPrice)
                .sum();
        model.addAttribute("expenses", expenses);
        model.addAttribute("expense", new Expense());
        model.addAttribute("sumOfPrices", sumOfPrices); // Add the sum to the model
        return "manageExpense";
    }

    @PostMapping("/addExpense")
    public String addExpense(Expense expense) {
        expense.setImageName("money2.jpg");
        log.error("This is an error message.");
        expenseRepository.save(expense);
        return "redirect:/manageExpense";
    }

    @PostMapping("/deleteExpense")
    public String deleteExpense(@RequestParam("expenseId") Long expenseId) {
        expenseRepository.deleteById(expenseId);
        log.info("ExpenseController::deleteExpense()");
        return "redirect:/manageExpense";
    }

    @GetMapping("/editExpense")
    public String editExpense(@RequestParam Long id, Model model) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        optionalExpense.ifPresent(expense -> model.addAttribute("expense", expense));
        return "editExpense";
    }


    @PostMapping("/changeExpense")
    public String changePizza(@ModelAttribute Expense expense, Model model) {
        expenseRepository.save(expense);

        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);

        return "manageExpense";
    }
}




