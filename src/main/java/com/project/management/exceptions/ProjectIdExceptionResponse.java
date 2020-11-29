package com.project.management.exceptions;

public class ProjectIdExceptionResponse {
	private String projectId;

	public ProjectIdExceptionResponse(String projectIdentification) {
		this.projectId = projectIdentification;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectIdentification) {
		this.projectId = projectIdentification;
	}

}
