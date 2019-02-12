package com.api.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.entities.ProjectTask;
import com.api.repositories.ProjectTaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestEntityManager
public class ProjectTaskServiceTest {

	@Mock
	private ProjectTaskRepository repositoryMock;
	@Autowired
	private ProjectTaskService service;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void persistProjectTaskTest() {
		ProjectTask projectTaskMock = new ProjectTask("summaryTest","criteria","status");
		when(repositoryMock.save(any(ProjectTask.class))).thenReturn(projectTaskMock);
		
		ProjectTask projectTask = new ProjectTask("SummaryTest","Criteria","Status");
		assertEquals(projectTask,service.persistProjectTask(projectTask));
	}
	
	@Test
	public void getAllProjectsTest() {
		List<ProjectTask> projectsMock = new ArrayList<ProjectTask>();
		when(repositoryMock.findAll()).thenReturn(projectsMock);
		
		List<ProjectTask> projects = service.getAllProjects();
		assertNotNull(projects);
		
	}
	
	@Test
	public void getById() {
		ProjectTask projectTaskMock = new ProjectTask("S11","criteria","DOING");
		when(repositoryMock.getById(any(Long.class))).thenReturn(projectTaskMock);
		
		ProjectTask projectFromDb = service.findById(projectTaskMock.getId());
		assertEquals(projectTaskMock,projectFromDb);
	}
}


