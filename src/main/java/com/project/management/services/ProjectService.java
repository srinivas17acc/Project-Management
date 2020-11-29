package com.project.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.exceptions.ProjectIdException;
import com.project.management.models.ProjectModel;
import com.project.management.repositories.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;

	public ProjectModel saveOrUpdateProject(ProjectModel project) {
		try {
			project.setpId(project.getpId().toUpperCase());
			return projectRepo.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID: " + project.getpId().toUpperCase() + " already exist");
		}

	}

	public ProjectModel findProjectById(String pId) {
		ProjectModel project = projectRepo.findBypId(pId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project ID: " + pId.toUpperCase() + " Not exist");
		}
		return project;
	}

	public Iterable<ProjectModel> findAllProject() {
		return projectRepo.findAll();
	}

	public void delete(String pId) {
		ProjectModel project = projectRepo.findBypId(pId);
		if (project == null) {
			throw new ProjectIdException("Project ID: " + pId.toUpperCase() + " Not exist");
		}
		projectRepo.delete(project);
	}

}
