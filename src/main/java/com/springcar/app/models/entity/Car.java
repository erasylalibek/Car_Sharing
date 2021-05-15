package com.springcar.app.models.entity;


import java.io.Serializable;

import javax.persistence.*;

@Entity
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
	private TypeTransmission transmission=TypeTransmission.MANUAL;

	private boolean ac=true;
	private int seats;
	private int doors;
	private Boolean status;
	private Long client_id;

	@ManyToOne
	@JoinColumn(name = "client_id",insertable = false, updatable = false)
	private Client client;


	@Column(name = "suit_cases")
	private int suitCases;

	private String photo;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TypeTransmission getTransmission() {
		return transmission;
	}

	public void setTransmission(TypeTransmission transmission) {
		this.transmission = transmission;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getSuitCases() {
		return suitCases;
	}

	public void setSuitCases(int suitCases) {
		this.suitCases = suitCases;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
