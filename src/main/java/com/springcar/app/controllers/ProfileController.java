package com.springcar.app.controllers;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.Client;
import com.springcar.app.models.entity.TypeTransmission;
import com.springcar.app.models.service.interfaces.ICarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springcar.app.models.entity.Reservation;
import com.springcar.app.models.service.interfaces.IOfficeMasterService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ICarService iCarService;

    @GetMapping("/profile/all")
    public void getCars(HttpSession session, Model model) {
        model.addAttribute("cars", iCarService.findAll());
    }

    @GetMapping("/profile/addCarr")
    public String addCar (HttpServletRequest request, HttpServletResponse response, Model model) {
        return "/user/profile/addCar";
    }

    @PostMapping("/profile/addCarr")
    public String addCarProcess (HttpSession session, @ModelAttribute ("addingCar") Car newCar) {

        iCarService.addCar(newCar);
        return "user/profile/index";
    }

    @GetMapping("/profile/deleteCarr")
    public String deleteCar (HttpServletRequest request, HttpServletResponse response, Model model) {
        return "/user/profile/deleteCar";
    }

    @PostMapping("/profile/deleteCarr")
    public String deleteCarProcess (HttpSession session, @ModelAttribute ("deleteCar") Car newCar) {

        iCarService.deleteCar(newCar);
        return "user/profile/index";
    }

    @PostMapping("/profile/filter")
    public String filterCarFleet(HttpSession session,
                                 @RequestParam(name="categorySelection") String categoryValue,
                                 @RequestParam(name="transmissionSelection") TypeTransmission transmissionValue,
                                 @RequestParam(name="priceOrderSelection") String priceOrderValue) {

        List<Car> fleet = iCarService.findAll();
        List<Car> filteredFleet = new ArrayList<Car>();

        if (!categoryValue.isEmpty()) {
            session.setAttribute("category", categoryValue);
            for (Car c : fleet) {
                if (c.getCategory().getCodCategory().equalsIgnoreCase(categoryValue)) {
                    filteredFleet.add(c);
                }
            }
            fleet.clear();
            fleet.addAll(filteredFleet);
        }else {
            session.removeAttribute("category");
        }

        if (transmissionValue != null) {
            session.setAttribute("transmission", transmissionValue.toString());
            filteredFleet.clear();
            for (Car c : fleet) {
                if (c.getTransmission().equals(transmissionValue)) {
                    filteredFleet.add(c);
                }
            }
            fleet.clear();
            fleet.addAll(filteredFleet);
        } else {
            session.removeAttribute("transmission");
        }

        if (priceOrderValue != null) {
            session.setAttribute("priceOrder", priceOrderValue);
            if (!fleet.isEmpty()) {
                filteredFleet = Utils.carSort(fleet, priceOrderValue);
            }
        } else {
            session.removeAttribute("priceOrder");
        }

        session.setAttribute("fleet", filteredFleet);

        return "redirect:user/profile/index";
    }
}
