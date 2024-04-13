package com.res.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.jsf.FacesContextUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resume")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "age", unique = true, nullable = false, length = 50)
	private Integer age;//年齡
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;
	@Column(name = "birth", unique = false, nullable = false, length = 50)
	@Temporal(TemporalType.DATE)
	private Date birth;
	@Column(name = "resume", unique = true, nullable = true, length = 1000)
	private String resume;
	@Column(name = "workex", unique = true, nullable = true, length = 500)
	private String workex;
	@Column(name = "sex", unique = true, nullable = false, length = 50)
	private String sex;
	@Column(name = "email", unique = true, nullable = false, length = 200)
	private String email;
	@Column(name = "phone", unique = true, nullable = false, length = 200)
	private String phone;
	@Column(name = "contact", unique = true, nullable = false, length = 200)
	private String contact;
	@Column(name ="stuex", unique = true, nullable = true, length = 500)
	private String stuex;
	@Column(name = "count")
	private int count;
	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MessageBoard> messageBoards = new HashSet<>();
	@OneToMany(mappedBy = "resume", fetch = FetchType.EAGER, orphanRemoval = false)
	@OrderBy("id ASC")
	private Set<InterestsData> interestsDatas = new LinkedHashSet<>();
	
}
