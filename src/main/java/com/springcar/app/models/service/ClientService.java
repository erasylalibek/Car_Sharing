package com.springcar.app.models.service;

import java.util.ArrayList;
import java.util.List;

import com.springcar.app.models.dao.ICarDao;
import com.springcar.app.models.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcar.app.models.dao.IClientDao;
import com.springcar.app.models.entity.Client;
import com.springcar.app.models.service.interfaces.IClientService;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientDao clientDao;

    @Autowired
    ICarDao iCarDao;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    public void save(Client client) {
        clientDao.save(client);

    }

    @Override
    public void delete(Client client) {
        clientDao.delete(client);

    }

    @Override
    public Client findByidNumer(String idNumber) {
        return clientDao.findByidNumer(idNumber).orElse(null);

    }

    @Override
    public Client findByUser(String user) {
        return clientDao.findByUser(user).orElse(null);
    }

    @Override
    public List<Car> getAllCarsOfUser(Long id) {
        List<Car> result = new ArrayList<>();

        List<Car> carList = iCarDao.findAllBy();

        for (Car car : carList) {
            if (id.equals(car.getClient_id())) {
                result.add(car);
            }
        }

        return result;
    }

    @Override
    public List<Car> getAllBookedCarsOfUser(Long id) {
        List<Car> result = new ArrayList<>();

        List<Car> carList = iCarDao.findAllByStatusIsTrue();

        for (Car car : carList) {
            if (id.equals(car.getClient_id())) {
                result.add(car);
            }
        }

        return result;
    }

    @Override
    public List<Car> getAllAvailableCarsOfUser(Long id) {
        List<Car> result = new ArrayList<>();

        List<Car> carList = iCarDao.findAllByStatusIsFalse();

        for (Car car : carList) {
            if (id.equals(car.getClient_id())) {
                result.add(car);
            }
        }

        return result;
    }


}
