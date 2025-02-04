package com.example.taskmanager.service;

import com.example.taskmanager.entity.Profile;
import com.example.taskmanager.presistence.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ProfileService {

    private final JdbcTemplate jdbcTemplate;

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(JdbcTemplate jdbcTemplate, ProfileRepository profileRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }


    @Transactional
    public void executeSqlCommands() {
        // Execute SQL commands
        jdbcTemplate.update("INSERT INTO task_counts (done_count) SELECT COUNT(*) FROM tbl_task WHERE completed = 1");
        jdbcTemplate.update("INSERT INTO task_counts (not_done_count) SELECT COUNT(*) FROM tbl_task WHERE completed = 0");
    }

    @RestController
    @RequestMapping("/api/data")
    public class DataController {

        private final ProfileService ProfileService; // You'll need to create a service for your data

        public DataController(ProfileService ProfileService) {
            this.ProfileService = ProfileService;
        }

        @GetMapping("/chart")
        public List<Profile> getProfileData() {
            return ProfileService.getAllProfiles();
        }
    }

}
