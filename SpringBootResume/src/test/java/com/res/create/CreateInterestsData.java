package com.res.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.res.entity.InterestsData;
import com.res.entity.Resume;
import com.res.repository.InterestsDataRepository;
import com.res.repository.ResumeRepository;

@SpringBootTest
public class CreateInterestsData {
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private InterestsDataRepository interestsDataRepository;
	
	@Test
	public void test() {
		InterestsData i1 = new InterestsData();
		i1.setName("健身");
		InterestsData i2 = new InterestsData();
		i2.setName("閱讀");
		InterestsData i3 = new InterestsData();
		i3.setName("追劇");
		
		Resume r1= resumeRepository.findById(1L).get();
		
		i1.setResume(r1);
		i2.setResume(r1);
		i3.setResume(r1);
		
		interestsDataRepository.save(i1);
		interestsDataRepository.save(i2);
		interestsDataRepository.save(i3);
		
		System.out.println("save ok");
		
	}
}
