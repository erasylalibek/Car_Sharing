package com.springcar.app.models.service;

import java.util.List;

import com.springcar.app.models.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.ICarDao;
import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.Category;
import com.springcar.app.models.entity.TypeTransmission;
import com.springcar.app.models.service.interfaces.ICarService;

@Service
public class CarService implements ICarService{
	
	@Autowired
	ICarDao carDao;

	@Autowired
	private ICarRepository iCarRepository;




	@Override
	public List<Car> findByTransmission(TypeTransmission transmission) {
		return carDao.findByTransmission(transmission).orElse(null);
	}

	@Override
	public List<Car> findAll() {
		return (List<Car>) carDao.findAll();
	}

	@Override
	public List<Car> findByCategory(String category) {
		return  carDao.findByCategory(category).orElse(null);
	}

	@Override
	public List<Car> findByTransmissionAndCategory(TypeTransmission transmission, String Category) {
		return carDao.findByTransmissionAndCategory(transmission, Category).orElse(null);
	}

	@Override
	public Car findById(Long id) {
		return carDao.findById(id).orElse(null);
	}

	@Override
	public void addCar(Car car) {
		iCarRepository.save(car);
	}

	@Override
	public void deleteCar(Car car) {
		iCarRepository.delete(car);
	}
}
