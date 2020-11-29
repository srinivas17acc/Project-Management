package com.project.management.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.management.models.ProjectModel;

public interface ProjectRepo extends CrudRepository<ProjectModel, Long> {

	ProjectModel findBypId(String pId);

	Iterable<ProjectModel> findAll();

}
