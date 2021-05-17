package com.springboot.samplerealtime.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.samplerealtime.project.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
