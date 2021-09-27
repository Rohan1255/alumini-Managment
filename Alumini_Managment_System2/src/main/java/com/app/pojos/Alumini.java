package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alumini")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Alumini extends BaseEntiity {
	@Column(length = 20, nullable = false)
	@NotBlank(message = "First name is required")
	private String firstName;
	@Column(length = 20, nullable = false)
	@NotBlank(message = "Last  name is required")
	private String lastName;
	@Column(length = 30, unique = true, nullable = false)
	@NotBlank(message = "Email is required")
	private String email;
	@Column(length = 20, unique = true, nullable = false)
	private String userName;
	@Column(length = 20)
	@NotBlank(message = "Mobile Number is Required")
	private String mobileNo;
	@NotBlank(message = "Password  is required")
	private String password;
	@Column(length = 20)
	private String passingYear;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;
	@OneToOne(cascade = CascadeType.ALL)
	private Address Address;
	@ManyToOne
	private Course course;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "alumini")
	@JsonIgnore
	List<Update> jobUpdates;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "alumini")
	@JsonIgnore
	List<Feedback> feedbacks;

}
