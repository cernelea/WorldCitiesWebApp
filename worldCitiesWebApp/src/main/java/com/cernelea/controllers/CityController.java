package com.cernelea.controllers;


import com.cernelea.DAO.daoService.ServiceDAO;
import com.cernelea.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/city")

public class CityController {
    @Autowired
    private ServiceDAO serviceDAO;


    @GetMapping("/list")
    public String showCityList(Model model) {
        List<City> cityList = serviceDAO.cityList();

        model.addAttribute("cityList", cityList);


        return "city-list";
    }


}
