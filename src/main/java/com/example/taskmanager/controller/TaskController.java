package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.presistence.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // user-------------------
    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAllByOrderByIdDesc();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    // admin ---------------------
    @GetMapping("/manageTask")
    public String manageTask(Model model) {
        List<Task> tasks = taskRepository.findAllByOrderByIdDesc();
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", tasks);
        return "manageTask";
    }

    @PostMapping("/addTask")
    public String addTask(Task task, Model model) {
        taskRepository.save(task);

        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskRepository.findAll()); // Retrieve tasks from the repository

        return "redirect:/manageTask";
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") Long taskId) {
        taskRepository.deleteById(taskId);
        return "redirect:/manageTask"; // Redirect to a page showing the updated task list.
    }

    @GetMapping("/editTask")
    public String editTask(@RequestParam Long id, Model model) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        optionalTask.ifPresent(task -> model.addAttribute("task", task));
        return "editTask";
    }

    @PostMapping("/changeTask")
    public String changeTask(@ModelAttribute Task task, Model model) {
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }



}

