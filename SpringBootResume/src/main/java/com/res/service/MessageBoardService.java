package com.res.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.res.entity.MessageBoard;
import com.res.entity.Resume;
import com.res.repository.MessageBoardRepository;
import com.res.repository.ResumeRepository;

@Service
public class MessageBoardService {
	@Autowired
	private MessageBoardRepository messageBoardRepository;
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	public void addMessage(Long id, String content,String author) {
		Resume resume = resumeRepository.findById(id).orElse(null);
		if(resume!=null) {
			MessageBoard message = new MessageBoard();
			message.setAuthor(author);
			message.setContent(content);
			message.setPostDate(new Date());
			message.setResume(resume);
			resume.getMessageBoards().add(message);
			message.setViewCount(message.getViewCount()+1);
			resumeRepository.save(resume);
		}
	}
}
	
