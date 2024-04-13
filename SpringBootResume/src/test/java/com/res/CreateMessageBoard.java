package com.res;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.res.entity.MessageBoard;
import com.res.entity.Resume;
import com.res.repository.MessageBoardRepository;
import com.res.repository.ResumeRepository;

@SpringBootTest
public class CreateMessageBoard {
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private MessageBoardRepository messageBoardRepository;
	
	@Test
	public void test() {
		MessageBoard mb1 = new MessageBoard();
		
		Resume r1 = resumeRepository.findById(1L).get();
		
		mb1.setResume(r1);
		
		messageBoardRepository.save(mb1);
		
		System.out.println("save ok");
	}
}
