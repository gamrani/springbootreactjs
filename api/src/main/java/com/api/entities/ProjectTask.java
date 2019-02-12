package com.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Summary cannot be blank")
	private String summary;
	private String acceptanceCriteria;
	private String status;

	
	public ProjectTask() {
		super();
	}
	public ProjectTask(@NotBlank(message = "Summary cannot be blank") String summary, String acceptanceCriteria,
			String status) {
		super();
		this.summary = summary;
		this.acceptanceCriteria = acceptanceCriteria;
		this.status = status;
	}
	public String getSummary() {
		return summary;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
