package com.cernelea.DAO.countryDAO;

import com.cernelea.DAO.DAO;
import com.cernelea.entity.City;
import com.cernelea.entity.Country;
import com.cernelea.entity.CountryLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository

public class CountryDAOImpl implements CountryDAO, DAO<Country> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Country> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Country> countryQuery = session.createQuery("from Country", Country.class);
        List<Country> countryList = countryQuery.getResultList();


        return countryList;
    }

    @Override
    public List<City> getCitiesForCountry(String code) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, code);

        List<City> cityList1 = new ArrayList<>(country.getCityList());

        return cityList1;


    }

    @Override
    public List<CountryLanguage> getCountryLanguages(String code) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, code);

        List<CountryLanguage> countryLanguages = new ArrayList<>(country.getCountryLanguages());


        return countryLanguages;
    }
}
