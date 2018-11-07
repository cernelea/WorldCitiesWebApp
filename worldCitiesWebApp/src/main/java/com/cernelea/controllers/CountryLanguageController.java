package com.cernelea.controllers;


import com.cernelea.DAO.daoService.ServiceDAO;
import com.cernelea.entity.CountryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/countryLanguage")
public class CountryLanguageController {
    @Autowired
    private ServiceDAO serviceDAO;

    @GetMapping("/list")
    public String showCountryLanguageList(Model model) {
        List<CountryLanguage> countryLanguageList = serviceDAO.getCountryLanguageList();
        model.addAttribute("countryLanguageList", countryLanguageList);

        return "countryLanguage-list";


    }


}
