package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Profile;
import com.example.taskmanager.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }



    @PostMapping("/executeSql")
    public String executeSqlCommands() {
        // Execute your SQL commands using the ProfileService
        profileService.executeSqlCommands();

        return "redirect:/profile"; // Redirect to the profile page or any other page after executing SQL commands
    }


        @GetMapping("/profile")
        public String showProfilePage(Model model) {
            List<Profile> profile = profileService.getAllProfiles();
            model.addAttribute("profile", profile);
            return "profile"; // profile.html template
        }
    }


