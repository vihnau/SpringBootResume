package com.res.create;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.res.entity.Resume;
import com.res.repository.ResumeRepository;

@SpringBootTest
public class CreateResume {
	@Autowired
	private ResumeRepository resumeRepository;

	@Test
	public void test() {
		Resume r1 = new Resume();
		r1.setName("廖育軒");
		r1.setAge(27);
		// 创建一个 DateTimeFormatter 对象，并指定日期格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// 使用 DateTimeFormatter 解析字符串为 LocalDate 对象
		LocalDate localDate = LocalDate.parse("1996-09-25", formatter);

		// 将 LocalDate 转换为 java.util.Date
		Date date = java.sql.Date.valueOf(localDate);
		r1.setBirth(date);
		r1.setSex("男");
		r1.setWorkex("壽險顧問"+"年資:1年半\n"+"作業員"+"年資:2年\n"+"飲料店員 年資:3年");
		r1.setEmail("vihnau6743@gmail.com");
		r1.setPhone("0909273520");
		r1.setContact("中午或下午六點後");
		r1.setStuex("中台科技大學資料管理系");
		r1.setResume("");
		resumeRepository.save(r1);
		System.out.println("save ok");
	}
}
