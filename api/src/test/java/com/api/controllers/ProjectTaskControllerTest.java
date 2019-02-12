package com.api.controllers;

import static org.mockito.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.api.entities.ProjectTask;
import com.api.services.ProjectTaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectTaskControllerTest {

	@Mock
	private ProjectTaskService serviceMock;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ProjectTaskController controller;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private String url = "/api/board";
	@Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void saveProjectTaskTest() throws JsonProcessingException, Exception {
       ProjectTask projectTask = new ProjectTask("A","B","C");
       when(serviceMock.persistProjectTask(any(ProjectTask.class))).thenReturn(projectTask); 
       
       this.mockMvc.perform(
    		     post(url+"/saveProjectTask")
    		       .contentType(MediaType.APPLICATION_JSON)
    		       .content(objectMapper.writeValueAsString(projectTask))
    		   )
       .andExpect(status().isCreated());
       //System.out.println("######### Content() - : "+content());
	}
	
	
	public void getAllProjectsTest() throws Exception {
		List<ProjectTask> projectsMock = new ArrayList<ProjectTask>();
		projectsMock.add(new ProjectTask("a","a","a"));
		projectsMock.add(new ProjectTask("b","b","b"));
		
		when(serviceMock.getAllProjects()).thenReturn(projectsMock);
		
		this.mockMvc.perform(get(url+"/allProjects")).andExpect(status().isFound());
		
	}

}
