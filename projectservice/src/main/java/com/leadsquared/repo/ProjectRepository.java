package com.leadsquared.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadsquared.entities.ProjectEntity;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{



}
