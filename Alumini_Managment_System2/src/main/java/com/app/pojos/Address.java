package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntiity {
	@Column(length = 50)
	@NotBlank(message = "Please Enter Address")
	private String fullAddress;
	@Column(length = 20)
	@NotBlank(message = "Please Enter City")
	private String city;
	@Column(length = 20)
	@NotBlank(message = "Please Enter State")
	private String state;
	@Column(length = 20)
	@NotBlank(message = "Please Enter Country")
	private String country;
}
