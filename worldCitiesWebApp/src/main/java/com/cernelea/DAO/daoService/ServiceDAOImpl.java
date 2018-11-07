package com.cernelea.DAO.daoService;


import com.cernelea.DAO.DAO;
import com.cernelea.DAO.countryDAO.CountryDAOImpl;
import com.cernelea.entity.City;
import com.cernelea.entity.Country;
import com.cernelea.entity.CountryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ServiceDAOImpl implements ServiceDAO {

    @Autowired
    private DAO<City> cityDAO;

    @Autowired
    private DAO<CountryLanguage> countryLanguageDAO;

    @Autowired
    private CountryDAOImpl countryDAO;


    @Override
    public List<City> cityList() {


        return cityDAO.getList();
    }


    @Override
    public List<CountryLanguage> getCountryLanguageList() {

        return countryLanguageDAO.getList();
    }


    @Override
    public List<Country> getCountryList() {
        return countryDAO.getList();
    }


    @Override
    public List<City> getCityListForCountry(String code) {
        return countryDAO.getCitiesForCountry(code);
    }


    @Override
    public List<CountryLanguage> getCountryLanguage(String code) {
        return countryDAO.getCountryLanguages(code);
    }
}
