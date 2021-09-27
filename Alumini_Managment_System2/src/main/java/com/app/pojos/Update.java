package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_updates")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Update extends BaseEntiity {
	@Column(length = 20, nullable = false)
	@NotBlank(message = "Enter Title")
	private String title;
	@Column(length = 150, nullable = false)
	@NotBlank(message = "Enter Details")
	private String jobDescription;
	@ManyToOne
	@JoinColumn(name="alumini_id")
	private Alumini alumini;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate postedOn;
}
