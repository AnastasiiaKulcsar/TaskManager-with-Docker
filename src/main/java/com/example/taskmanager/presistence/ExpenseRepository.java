package com.example.taskmanager.presistence;

import com.example.taskmanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository <Expense, Long> {
}


