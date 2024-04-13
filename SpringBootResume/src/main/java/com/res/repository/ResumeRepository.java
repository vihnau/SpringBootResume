package com.res.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.res.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>{

}
