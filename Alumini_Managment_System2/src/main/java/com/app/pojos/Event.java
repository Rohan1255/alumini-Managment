package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntiity {
	@Column(length = 20)
	@NotBlank(message = "Event name required")
	private String eventName;
	@Column(length = 150)
	@NotBlank(message = "Description name required")
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
}
