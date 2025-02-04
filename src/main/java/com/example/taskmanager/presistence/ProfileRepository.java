package com.example.taskmanager.presistence;

import com.example.taskmanager.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
