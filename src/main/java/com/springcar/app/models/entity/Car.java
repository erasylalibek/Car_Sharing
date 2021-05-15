package com.springcar.app.models.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long car_id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	private String model;
	private String marca;

	@Enumerated(EnumType.STRING)
	private TypeTransmission transmission;

	private boolean ac;
	private int seats;
	private int doors;
	private Boolean status;
	private Long client_id;

	@ManyToOne
	@JoinColumn(name = "client_id",insertable = false, updatable = false)
	@Getter(AccessLevel.NONE)
	private Client client;


	@Column(name = "suit_cases")
	private int suitCases;

	private String photo;


}
