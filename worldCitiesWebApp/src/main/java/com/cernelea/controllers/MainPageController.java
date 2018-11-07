package com.cernelea.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainPage")
public class MainPageController {

@RequestMapping("/showMainPage")
    public String showMainPage(){


    return "show-mainPage";

}


}
