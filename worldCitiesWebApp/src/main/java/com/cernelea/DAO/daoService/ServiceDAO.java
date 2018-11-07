package com.cernelea.DAO.daoService;

import com.cernelea.entity.City;
import com.cernelea.entity.Country;
import com.cernelea.entity.CountryLanguage;

import java.util.List;

public interface ServiceDAO {
    List<City> cityList();

    List<CountryLanguage> getCountryLanguageList();

    List<Country> getCountryList();

    List<City> getCityListForCountry(String code);

    List<CountryLanguage> getCountryLanguage(String code);


}
