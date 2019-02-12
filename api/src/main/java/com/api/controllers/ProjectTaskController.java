package com.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.ProjectTask;
import com.api.services.ProjectTaskService;

@RestController @RequestMapping("/api/board") @CrossOrigin
public class ProjectTaskController {
	
	
	@Autowired
	private ProjectTaskService service;

	@PostMapping("/saveProjectTask")
	public ResponseEntity<?> saveProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
		
		if(result.hasErrors()) {
			return getRequestError(result);
		}
		
		ProjectTask savedProjectTask = service.persistProjectTask(projectTask);
		return new ResponseEntity<ProjectTask>(savedProjectTask,HttpStatus.CREATED);	
	}
	
	@GetMapping("/allProjects")
	public ResponseEntity<?> getAllProjects(){
		List<ProjectTask> projects = service.getAllProjects();
		
		if(projects==null) {
			return new ResponseEntity<List<ProjectTask>>(projects,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProjectTask>>(projects,HttpStatus.FOUND);
	}
	
	@GetMapping("/project/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		ProjectTask project = service.findById(id);
		
		if(project==null) {
			return new ResponseEntity<String>("Project with id "+id+" doesn't exist",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProjectTask>(project,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/removeProject")
	public ResponseEntity<?> deleteProjectTask(@RequestBody ProjectTask projectTask){
		
		if(service.findById(projectTask.getId())!=null) {
			service.deleteProjectTask(projectTask);
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("This project task doesn't exist",HttpStatus.NOT_FOUND);
	
	}
	
	
	
	/**UTILS**/
	private ResponseEntity<?> getRequestError(BindingResult result){
		Map<String,String> errorsMap = new HashMap();
		
		for(FieldError error:result.getFieldErrors()) {
			errorsMap.put(error.getField(), error.getDefaultMessage());
		}
		
		return new ResponseEntity<Map<String,String>>(errorsMap,HttpStatus.BAD_REQUEST);
	}
}
