package com.res.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.res.entity.MessageBoard;
import com.res.entity.Resume;
import com.res.repository.ResumeRepository;
import com.res.service.MessageBoardService;
import com.res.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired 
	private ResumeService resumeService;
	
	@Autowired
	private MessageBoardService messageBoardService;
	
	@GetMapping("/")
	public String index(@ModelAttribute Resume resume, Model model) {
		List<Resume> resumes = resumeService.findAll();
		model.addAttribute("resumes", resumes);
		model.addAttribute("resume", resume);
		if(!resumes.isEmpty()) {
			Resume r1 = resumes.get(0);
			r1.setCount(r1.getCount()+1);
			resumeRepository.save(r1);
		}
		return "resume";
	}
	
	@PostMapping("/addMessage")
	public String addMessage(Long id, String content,String author, @ModelAttribute Resume resume, Model model) {
		Resume r1 = resumeService.findResumeById(id);
		if(r1!=null) {
			messageBoardService.addMessage(id, content, author);
		}
//		Resume resumes = resumeService.findResumeById(id);
////		Optional<Resume> resumeOpt = resumeService.findResumeById(id);
//		if(resumes!=null) {
//			MessageBoard messageBoard = new MessageBoard();
////			messageBoard.setAuthor(author);
//			messageBoard.setContent(content);
//			messageBoard.setPostDate(new Date());
//			messageBoard.setResume(resumes);
//			resumes.getMessageBoards().add(messageBoard);
//			resumeRepository.save(resumes);
//			model.addAttribute("resume",resume);
//			model.addAttribute("resumes",resumes);
//		}
		return "redirect:/resume/";
	}
	@PostMapping("/update")
	public String update(@RequestParam String resume,@RequestParam("id") Long id) {
		resumeService.update(resume, id);
		return "redirect:/resume/";
	}
}
