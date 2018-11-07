package com.cernelea.DAO.countryLanguageDAO;


import com.cernelea.DAO.DAO;
import com.cernelea.entity.CountryLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryLanguageDAOImpl implements DAO<CountryLanguage> {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<CountryLanguage> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query<CountryLanguage> countryLanguageQuery = session.createQuery("from CountryLanguage", CountryLanguage.class);
        List<CountryLanguage> countryLanguageList = countryLanguageQuery.getResultList();
        return countryLanguageList;
    }
}
