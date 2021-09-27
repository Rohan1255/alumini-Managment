package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Feedback extends BaseEntiity {
	private String suggesions;
	private String forum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@ManyToOne
	@JsonIgnore
	private Alumini alumini;
}
