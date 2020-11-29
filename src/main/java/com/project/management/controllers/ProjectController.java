package com.project.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.management.models.ProjectModel;
import com.project.management.services.MapValidationErrorService;
import com.project.management.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping(value = "")
	public ResponseEntity<?> projectSaveOrUpdate(@Valid @RequestBody ProjectModel project, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.validationService(result);
		if (errorMap != null)
			return errorMap;
		ProjectModel projectResp = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<ProjectModel>(projectResp, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		ProjectModel project = projectService.findProjectById(projectId);
		return new ResponseEntity<ProjectModel>(project, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public Iterable<ProjectModel> getAllProject() {
		return projectService.findAllProject();
	}

	@DeleteMapping(value = "/{projectId}")
	public ResponseEntity<?> deleteByProjectId(@PathVariable String projectId) {
		projectService.delete(projectId);
		return new ResponseEntity<>("Project Id : " + projectId + " deleted", HttpStatus.OK);
	}

}
