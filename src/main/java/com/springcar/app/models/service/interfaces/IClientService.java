package com.springcar.app.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.springcar.app.models.entity.Car;
import org.springframework.data.jpa.repository.Query;

import com.springcar.app.models.entity.Client;

public interface IClientService {
	
	public List<Client> findAll();
	public Client findById(Long id);
	public void save(Client client);
	public void delete(Client client);
	public Client findByidNumer(String idNumber);
	public Client findByUser(String user);
	public List<Car> getAllCarsOfUser(Long id);
	public List<Car> getAllBookedCarsOfUser(Long id);
	public List<Car> getAllAvailableCarsOfUser(Long id);

}
