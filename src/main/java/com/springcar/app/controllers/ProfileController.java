package com.springcar.app.controllers;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.Client;
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
}
