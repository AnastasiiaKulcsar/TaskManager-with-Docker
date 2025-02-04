package com.example.taskmanager;

import com.example.taskmanager.entity.Expense;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.presistence.ExpenseRepository;
import com.example.taskmanager.presistence.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Starter implements CommandLineRunner {

    private TaskRepository taskRepository;


    public Starter(TaskRepository taskRepository, ExpenseRepository expenseRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) {
        List<Task> tasks = List.of(
                /*new Task(12L, "Go  Buy groceries", 4, true ),
                new Task(17L, "Make website", 4, true )*/
        );
        taskRepository.saveAll(tasks);
    }
}