package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntiity {
	@Column(length = 20)
	private String courseName;
	@Column(length = 20)
	private String couseDuration;

	public Course(String courseName) {
		this.courseName = courseName;
	}
}
