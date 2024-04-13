package com.res.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.res.entity.InterestsData;

@Repository
public interface InterestsDataRepository extends JpaRepository<InterestsData, Long>{

}
