package com.res.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interestsData")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterestsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;
	@JoinColumn(name = "resume_id")//外鍵
	@ManyToOne(optional = false)
	private Resume resume;
}
