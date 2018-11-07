package com.cernelea.controllers;


import com.cernelea.DAO.daoService.ServiceDAO;
import com.cernelea.entity.City;
import com.cernelea.entity.Country;
import com.cernelea.entity.CountryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private ServiceDAO serviceDAO;


    @GetMapping("/list")

    public String showCountryList(Model model) {
        List<Country> countryList = serviceDAO.getCountryList();

        model.addAttribute("countryList", countryList);

        return "show-countryList";


    }

    @GetMapping("/showCitiesForCountry")
    public String showCitiesForCountry(@RequestParam("code") String code, Model model) {
        List<City> cityList = serviceDAO.getCityListForCountry(code);
        model.addAttribute("cityList", cityList);


        return "city-list";
    }

    @GetMapping("/showLanguagesForCountry")
    public String showLanguagesForCountry(@RequestParam("code") String code, Model model) {
        List<CountryLanguage> countryLanguages = serviceDAO.getCountryLanguage(code);
        model.addAttribute("countryLanguageList", countryLanguages);


        return "countryLanguage-list";
    }


}
