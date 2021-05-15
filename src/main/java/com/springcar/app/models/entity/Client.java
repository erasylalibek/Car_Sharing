package com.springcar.app.models.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long client_id;

	@NotEmpty(message = "El campo no es opcional")
	private String name;
	
	@NotEmpty(message = "El campo no es opcional")
	private String surname;
	
	@NotEmpty(message = "El campo no es opcional")
	@Column(name = "id_number")
	private String idNumber;
	
	@NotEmpty(message = "El campo no es opcional")
	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "client")
	private List<Car> cars;
	
	@NotEmpty(message = "El campo no es opcional")
	@Email(message = "formato incorrecto")
	private String email;
	
	private String address;
	private String postCode;
	private String city;
	private String country;
	
	
	@NotEmpty(message = "El campo no es opcional")
	@Column(name = "user_name")
	private String userName;
	
	@NotEmpty(message = "El campo no es opcional")
	private String password;

	public Client() {

	}

	public Client(@NotEmpty(message = "El campo no es opcional") String name,
			@NotEmpty(message = "El campo no es opcional") String surname,
			@NotEmpty(message = "El campo no es opcional") String idNumber,
			@NotEmpty(message = "El campo no es opcional") String phoneNumber,
			@NotEmpty(message = "El campo no es opcional") @Email(message = "formato incorrecto") String email,
			String address, String postCode, String city, String country,
			@NotEmpty(message = "El campo no es opcional") String userName,
			@NotEmpty(message = "El campo no es opcional") String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		this.userName = userName;
		this.password = password;
	}

}
