package com.masai.repository;

import com.masai.model.GitHubDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubDataRepository extends JpaRepository<GitHubDataEntity, Long> {

}