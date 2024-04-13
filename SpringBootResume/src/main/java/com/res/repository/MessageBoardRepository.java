package com.res.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.res.entity.MessageBoard;
@Repository
public interface MessageBoardRepository extends JpaRepository<MessageBoard, Integer>{

}
