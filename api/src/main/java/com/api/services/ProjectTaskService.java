package com.api.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.ProjectTask;
import com.api.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService implements ProjectTaskServiceInterface {

	@Autowired
	private ProjectTaskRepository repository;

	public ProjectTask persistProjectTask(ProjectTask projectTask) {
		// TODO Auto-generated method stub
		if(projectTask.getSummary()== null || projectTask.getSummary() == "") {
			projectTask.setStatus("TO_DO");
		}
		return repository.save(projectTask);
	}
	
	public List<ProjectTask> getAllProjects(){
		List<ProjectTask> allProjects = repository.findAll();
		
		if(allProjects!=null) {
			return allProjects;
		}
		
		return null;
	}

	@Override
	public ProjectTask findById(Long id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void deleteProjectTask(ProjectTask projectTask) {
		// TODO Auto-generated method stub
		repository.delete(projectTask);	
	}

	
}
