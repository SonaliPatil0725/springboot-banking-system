package com.exponent.banking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.exponent.banking.enums.UserStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "First name can't be blank.")
	@Size(max = 30)
	private String firstName;
	
	@NotBlank(message = "Last name can't be blank.")
	@Size(max = 30)
	private String lastName;
	
	@NotBlank(message = "Gender can't be blank.")
	private String gender;
	
	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;
	
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid Pan Format.")
	private String panNo;
	
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "\\d{12}", message = "Aadhar number must be exactly 12 digits")
	private String aadharNo;
	
	@Email(message = "Invalid EmailId Format.")
	@NotBlank(message = "Email is required.")
	@Column(unique = true, nullable = false)
	private String emailId;
	
	@NotBlank(message = "Contact Number is required.")
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
	private String contactNo;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.Active;
	
	@NotBlank(message = "Role is required.")
	private String role = "Customer";
	
	@CreationTimestamp
	private LocalDateTime registerDateTime;
	
}
