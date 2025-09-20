package com.exponent.banking.dto;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterDTO {

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

	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid Pan Format.")
	private String panNo;

	@Pattern(regexp = "\\d{12}", message = "Aadhar number must be exactly 12 digits")
	private String aadharNo;

	@Email(message = "Invalid EmailId Format.")
	@NotBlank(message = "Email is required.")
	private String emailId;

	@NotBlank(message = "Contact Number is required.")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
	private String contactNo;

}
