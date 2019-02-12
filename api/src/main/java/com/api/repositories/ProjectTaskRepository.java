package com.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

	public List<ProjectTask> findByStatus(String status);
	public ProjectTask getById(Long id);
	public Optional<ProjectTask> findById(Long id);
}
