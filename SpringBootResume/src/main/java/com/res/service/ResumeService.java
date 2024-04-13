package com.res.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.res.entity.InterestsData;
import com.res.entity.Resume;
import com.res.repository.ResumeRepository;

@Service
public class ResumeService {
	@Autowired
	private ResumeRepository resumeRepository;
	
	public List<Resume> findAll(){
		List<Resume> resumes = resumeRepository.findAll();
//		if(resumes!= null) {
//			Resume resume = new Resume();
//			String interests = resume.getInterestsDatas().stream().map(InterestsData::getName).collect(Collectors.joining(","));
//		}
		return resumes;
	}
	public Resume findResumeById(Long id) {
		Optional<Resume> resumeOpt = resumeRepository.findById(id);
		if(resumeOpt.isPresent()) {
			Resume resume = resumeOpt.get();
			return resume;
		}
		return null;
	}
	public void update(String resume , Long id) {
		Optional<Resume> resumeOpt = resumeRepository.findById(id);
		if(resumeOpt.isPresent()) {
			Resume r1 = resumeOpt.get();
			r1.setResume(resume);
			resumeRepository.save(r1);
		}
	}
}
