package com.cernelea.DAO.cityDAO;


import com.cernelea.DAO.DAO;
import com.cernelea.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDAOImpl implements DAO<City> {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<City> getList() {
        Session session = sessionFactory.getCurrentSession();

        Query<City> cityQuery = session.createQuery("from City", City.class);
        List<City> cityList = cityQuery.getResultList();

        return cityList;


    }
}
