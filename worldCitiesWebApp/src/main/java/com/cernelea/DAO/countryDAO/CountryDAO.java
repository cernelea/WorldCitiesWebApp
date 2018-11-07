package com.cernelea.DAO.countryDAO;

import com.cernelea.entity.City;
import com.cernelea.entity.Country;
import com.cernelea.entity.CountryLanguage;

import java.util.List;

public interface CountryDAO {



    List<City> getCitiesForCountry(String code);

    List<CountryLanguage> getCountryLanguages(String code);
}
