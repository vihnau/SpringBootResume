package com.res.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageBoard {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "content", nullable = true, length = 500)
    private String content;
    
    @Column(name = "post_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    
    @Column(name = "author", nullable = true, length = 100)
    private String author;
    
    @Column(name = "viewCount")
    private int viewCount;
    
    @JoinColumn(name = "resume_id")//外鍵
	@ManyToOne(optional = false)
	private Resume resume;
}
