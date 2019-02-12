package com.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.entities.ProjectTask;

@Service
public interface ProjectTaskServiceInterface {
	
	public List<ProjectTask> getAllProjects();
	public ProjectTask persistProjectTask(ProjectTask projectTask);
	public ProjectTask findById(Long id);
	public void deleteProjectTask(ProjectTask projectTask);

}
